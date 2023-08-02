package com.company.platform.neo4j;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.internal.InternalRelationship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryDetail {

    /**
     * 处理cypher return的 internalnodes格式
     * @param data
     * @return
     */
    public JSONObject nodes(InternalNode data){
        Map<String, Object> data1 = data.asMap();
        HashMap<String,Map<String,Object>> node = new HashMap<String,Map<String,Object>>();
        HashMap<String,Object> nodelable = new HashMap<String,Object>();
        nodelable.put("id",""+data.id());
        List labels_list = (List) data.labels();
        nodelable.put("labels",labels_list);
        nodelable.put("properties",data1);
        String jsonnode = JSON.toJSONString(nodelable);
        JSONObject single_node = JSON.parseObject(jsonnode);
        return single_node;
    }


    /**
     * 处理cypher return返回的internalrelationship格式和collection&singletonList格式
     * @param relationdatas
     * @return
     */
    public JSONObject relations(InternalRelationship relationdatas){
        HashMap<String,Object> relationlabels = new HashMap<String,Object>();
        Map<String,Object> props = relationdatas.asMap();
        relationlabels.put("id",relationdatas.id());
        relationlabels.put("startNode",relationdatas.startNodeId());
        relationlabels.put("endNode",relationdatas.endNodeId());
        relationlabels.put("type",relationdatas.type());
        relationlabels.put("properties",props);
        String jsonrel = JSON.toJSONString(relationlabels);
        JSONObject single_rel = JSON.parseObject(jsonrel);
        return single_rel;
    }

    public JSONObject paths(Object object){
        InternalPath path  = (InternalPath) object;
        ArrayList nodes = (ArrayList) path.nodes();
        for(int i=0; i<nodes.size(); i++){
            InternalNode node  = (InternalNode) nodes.get(i);
        }
        return null;
    }

    public static String apocNodeQueryStr(String query, String username){
        StringBuilder sb = new StringBuilder();
        sb.append("CALL apoc.export.json.query(\n\"");
        sb.append(query);
        sb.append("\", \n" +
                "\"nodes_.json\", \n" +username+
                "null)");
        String result = sb.toString();
        return result;
    }

    public static String apocRelationQueryStr(String query, String username){
        StringBuilder sb = new StringBuilder();
        sb.append("CALL apoc.export.json.query(\n\"");
        sb.append(query);
        sb.append("\", \n" +
                "\"relations.json\", \n" +username+
                "null)");
        String result = sb.toString();
        return result;
    }

    public static JSON jsonMerge(String neo4jpath, String username){
        return null;
    }

    public static JSON jsonPaser(String jsonPath){
        return null;
    }
}
