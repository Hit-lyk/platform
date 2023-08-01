package com.company.platform.screen.graphdemo;

import com.company.platform.state.GraphState;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.JavaScriptComponent;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("GraphDemo")
@UiDescriptor("graph-demo.xml")
public class GraphDemo extends Screen {
    @Autowired
    protected JavaScriptComponent neo4jhit;
    @Autowired
    protected Notifications notifications;

    @Subscribe
    protected void onInit(InitEvent event) {

        GraphState stateGraph = new GraphState();
        stateGraph.jsonData = "{\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"data\": [\n" +
                "                {\n" +
                "                    \"graph\": {\n" +
                "                        \"relationships\": [\n" +
                "                            {\n" +
                "                                \"startNode\": 2,\n" +
                "                                \"id\": 860,\n" +
                "                                \"type\": \"拥有实例\",\n" +
                "                                \"endNode\": 819,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 818,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 820,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 819,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 821,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 820,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 822,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 821,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 823,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 822,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 824,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 823,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 825,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 824,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 826,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 825,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 827,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 826,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 828,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 827,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 829,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 828,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 830,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 829,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 831,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 830,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 832,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 831,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 833,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 832,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 834,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 833,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 835,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 834,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 836,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 835,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 837,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 836,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 838,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 837,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 839,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 838,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 840,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 839,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 841,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 840,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 842,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 841,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 843,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 842,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 844,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 843,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 845,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 844,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 846,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 845,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 847,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 846,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 848,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 847,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 849,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 848,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 850,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 849,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 851,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 850,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 852,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 851,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 853,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 852,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 854,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 853,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 855,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 854,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 856,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 855,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 857,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 856,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 858,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 857,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 859,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 858,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 860,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"startNode\": 819,\n" +
                "                                \"id\": 859,\n" +
                "                                \"type\": \"具有属性\",\n" +
                "                                \"endNode\": 861,\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"包含\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                }\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"nodes\": [\n" +
                "                            {\n" +
                "                                \"id\": \"2\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"name\": \"战斗机\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"类型\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"819\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"nodetype\": \"weapon\",\n" +
                "                                    \"name\": \"F/A-18E/F/G“超级大黄蜂”舰载攻击/战斗机\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"战斗机\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"820\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"发动机数量\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"双发\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"发动机数量\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"821\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"图片\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"http://images.huanqiu.com/sarons/2013/07/b92e5ef37fb04e97f388750cd905b29b.jpg\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"图片\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"822\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"简介\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"F-18是美国麦道公司为美海军研制的舰载单座双发超音速多用途战斗攻击机，它主要用于海上防空，也可进行对地攻击。\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"简介\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"823\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"隐身性能\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"隐身性能\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"824\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"远距离超视距攻击能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"value\": \"0\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"远距离超视距攻击能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"825\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大起飞重量\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"16651\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大起飞重量\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"826\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"拦截空中目标\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"拦截空中目标\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"827\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"机长\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"18.4\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"机长\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"828\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"名称\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"F/A-18E/F/G“超级大黄蜂”舰载攻击/战斗机\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"名称\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"829\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"乘员\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"2人\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"乘员\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"830\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"争夺制空权\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"争夺制空权\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"831\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"机高_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"米\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"机高_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"832\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"研发单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"美国麦道公司\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"研发单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"833\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"对海打击能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"1\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"对海打击能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"834\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大飞行速度_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"米\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大飞行速度_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"835\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"近距支援\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"近距支援\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"836\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"高速突防能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"高速突防能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"837\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"气动布局\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"后掠翼\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"气动布局\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"838\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"机高\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"4.9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"机高\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"839\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"翼展\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"13.6\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"翼展\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"840\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"超低空持续飞行能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"超低空持续飞行能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"841\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大航程_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"米\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大航程_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"842\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"空重\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"10455\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"空重\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"843\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"首飞时间\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"19781118\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"首飞时间\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"844\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"对空打击能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"1\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"对空打击能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"845\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"对地打击能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"1\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"对地打击能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"846\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"发动机\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"两台通用电气F414-GE-400涡轮风扇发动机\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"发动机\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"847\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"首飞时间_详细\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"1978年11月18日\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"首飞时间_详细\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"848\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"全天候作战能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"全天候作战能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"849\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"抗干扰能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"抗干扰能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"850\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大起飞重量_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"克\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大起飞重量_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"851\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"翼展_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"米\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"翼展_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"852\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大飞行速度\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"1915000\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大飞行速度\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"853\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"精确制导能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"精确制导能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"854\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"机长_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"米\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"机长_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"855\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"防护能力\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"防护能力\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"856\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"最大航程\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"1445000\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"最大航程\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"857\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"空重_单位\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"克\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"空重_单位\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"858\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"BOOL\",\n" +
                "                                    \"name\": \"远距侦察\",\n" +
                "                                    \"属性类型\": \"需求属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"0\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"远距侦察\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"859\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"大类\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"value\": \"飞行器\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"大类\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"860\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"产国\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"美国\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"产国\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"id\": \"861\",\n" +
                "                                \"properties\": {\n" +
                "                                    \"dataType\": \"STRING\",\n" +
                "                                    \"name\": \"类型\",\n" +
                "                                    \"属性类型\": \"其他属性\",\n" +
                "                                    \"uuid\": \"9c71770c-aef6-4798-ab73-f700c8f891b9\",\n" +
                "                                    \"value\": \"战斗机\"\n" +
                "                                },\n" +
                "                                \"labels\": [\n" +
                "                                    \"类型\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        neo4jhit.setState(stateGraph);
    }

//    @Subscribe("showValueBtn")
//    protected void onShowValueBtnClick(Button.ClickEvent event) {
//        timePicker.callFunction("showValue");
//    }
}