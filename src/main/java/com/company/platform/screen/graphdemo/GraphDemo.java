package com.company.platform.screen.graphdemo;

import com.company.platform.neo4j.QueryDetail;
import com.company.platform.state.GraphState;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.JavaScriptComponent;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.neo4j.driver.Record;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.internal.InternalRelationship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.neo4j.driver.*;

@UiController("GraphDemo")
@UiDescriptor("graph-demo.xml")
public class GraphDemo extends Screen {
    @Autowired
    protected JavaScriptComponent neo4jhit;
    @Autowired
    protected Notifications notifications;

    protected String strNeo4jUrl = "bolt://182.92.222.204:8383";
    protected String strNeo4jUserName = "neo4j";
    protected String strNeo4jPassword = "123456";
    public JSONObject executeCypher(String cypher) {
        Driver driver = GraphDatabase.driver(strNeo4jUrl, AuthTokens.basic(strNeo4jUserName, strNeo4jPassword));
        Session session = driver.session();
        Result result = session.run(cypher);
        JSONObject graph = new JSONObject();
        JSONArray nodes = new JSONArray();
        JSONArray relationships = new JSONArray();
        QueryDetail queryDetail = new QueryDetail();
        while (result.hasNext()) {
            Record record = result.next();
            Map<String, Object> date = record.asMap();
            for (String key : date.keySet()) {
                Object object = date.get(key);
                if (object.getClass().isAssignableFrom(InternalNode.class)) {
                    InternalNode data = (InternalNode) object;
                    JSONObject single_node = queryDetail.nodes(data);
                    if (nodes.contains(single_node)) {
                    } else {
                        nodes.add(single_node);
                    }
                } else if (object.getClass().isAssignableFrom(InternalRelationship.class)) {
                    InternalRelationship relationdatas = (InternalRelationship) object;
                    JSONObject single_rel = queryDetail.relations(relationdatas);
                    if (relationships.contains(single_rel)) {
                    } else {
                        relationships.add(single_rel);
                    }
                } else if (object.getClass().isAssignableFrom(InternalPath.class)) {
                    InternalPath path = (InternalPath) object;
                    List nodesarr = (List) path.nodes();
                    for (int i = 0; i < nodesarr.size(); i++) {
                        InternalNode node = (InternalNode) nodesarr.get(i);
                        JSONObject pathnode = queryDetail.nodes(node);
                        if (nodes.contains(pathnode)) {
                        } else {
                            nodes.add(pathnode);
                        }
                    }
                    List relsarr = (List) path.relationships();
                    for (int i = 0; i < relsarr.size(); i++) {
                        InternalRelationship rel = (InternalRelationship) relsarr.get(i);
                        JSONObject pathrel = queryDetail.relations(rel);
                        if (relationships.contains(pathrel)) {
                        } else {
                            relationships.add(pathrel);
                        }
                    }
                } else {
                    List list = (List) object;
                    InternalRelationship relationdatas = (InternalRelationship) list.get(0);
                    JSONObject single_rel = queryDetail.relations(relationdatas);
                    if (relationships.contains(single_rel)) {
                    } else {
                        relationships.add(single_rel);
                    }
                }
            }
        }
        graph.put("nodes", nodes);
        graph.put("relationships", relationships);
        System.out.println(graph);
        session.close();
        driver.close();
        return graph;
    }
    @Subscribe
    protected void onInit(InitEvent event) {

        GraphState stateGraph = new GraphState();
        stateGraph.graphData = executeCypher("MATCH p=()-->() RETURN p LIMIT 25").toJSONString();
        neo4jhit.setState(stateGraph);
    }

//    @Subscribe("showValueBtn")
//    protected void onShowValueBtnClick(Button.ClickEvent event) {
//        timePicker.callFunction("showValue");
//    }
}