javascript_component_neo4jd3 = function () {
    let connector = this;
    let element = connector.getElement();
    element.innerHTML = "<div id='neo4jd3' style='width:600px;height:600px'/>";

    // Handle changes from the server-side
    this.onStateChange = function () {
        let data = this.getState().data;
    var neo4jd3 = new Neo4jd3('#neo4jd3', {
//        neo4jDataUrl: Feng.ctxPath + '/extraction_result/kgResult?id='+Feng.getUrlParam("id"), // 改动即可
        neo4jData: JSON.parse(data.jsonData),
        nodeRadius: 27,
        onLoadDataFinish: function(size) {
        },
        onInfoChange: function (info) {
        },
        onNodeClick: function (node) {
        }
    });

        // Define a function that can be called from the server side
        connector.showValue = function () {
        };
    };
};