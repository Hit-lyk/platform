(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.Neo4jd3 = f()}})(function(){var define,module,exports;return (function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(_dereq_,module,exports){
        'use strict';

        var neo4jd3 = _dereq_('./scripts/neo4jd3');

        module.exports = neo4jd3;

    },{"./scripts/neo4jd3":2}],2:[function(_dereq_,module,exports){
        /* global d3, document */
        /* jshint latedef:nofunc */
        'use strict';

        function Neo4jD3(_selector, _options) {
            var container, nodeSet, nodes, relationship, relationshipOutline, relationshipOverlay, relationshipText, relationships, selector, simulation, svg, svgNodes, svgRelationships,
                itemInfo,
                classes2colors = {},
                justLoaded = false,
                numClasses = 0,
                svgScale = 1,
                svgTranslate = [0, 0],
                eventTransform = {
                    k:1,
                    x:0,
                    y:0
                },
                options = {
                    arrowSize: 4,
                    colors: colors(),
                    minCollision: 50,
                    neo4jData: undefined,
                    neo4jDataUrl: undefined,
                    urlGraphData: undefined,
                    nodeOutlineFillColor: undefined,
                    nodeRadius: 25,
                    nodeType: 0,
                    relationshipColor: '#a5abb6',
                    zoomFit: true
                },
                VERSION = '2.0.0';

            function appendGraph(container) {
                svg = container.append('svg')
                    .attr('width', '100%')
                    .attr('height', '100%')
                    .attr('class', 'neo4jd3-graph')
                    .call(d3.zoom().on('zoom', function() {
                        var scale = d3.event.transform.k,
                            translate = [d3.event.transform.x, d3.event.transform.y];

                        eventTransform = d3.event.transform;

                        scale *= svgScale;
                        translate[0] += svgTranslate[0];
                        translate[1] += svgTranslate[1];

                        svg.attr('transform', 'translate(' + translate[0] + ', ' + translate[1] + ') scale(' + scale + ')');
                    }))
                    .on('click', function(d) {
                        itemInfo = {
                            type: 0,
                            size: size()
                        };
                        nodeSet.attr('class', "node");
                        relationship.attr('class', "relationship");
                        if (typeof options.onInfoChange === 'function') {
                            options.onInfoChange(itemInfo);
                        }
                    })
                    .on('dblclick.zoom', null)
                    .append('g')
                    .attr('width', '100%')
                    .attr('height', '100%');

                svgRelationships = svg.append('g')
                    .attr('class', 'relationships');

                svgNodes = svg.append('g')
                    .attr('class', 'nodes');
            }

            function appendNode() {
                return nodeSet.enter()
                    .append('g')
                    .attr('class', 'node')
                    .on('click', function(d) {
                        d.fx = d.fy = null;

                        itemInfo = {
                            type: 1,
                            color: d.properties.color?d.properties.color:class2color(d.labels[0]),
                            node: d
                        }
                        nodeSet.attr('class', "node");
                        relationship.attr('class', "relationship");
                        d3.select(this).attr('class', "node selected");

                        if (typeof options.onNodeClick === 'function') {
                            options.onNodeClick(d);
                        }
                        d3.event.stopPropagation();
                    })
                    .on('dblclick', function(d) {
                        if (typeof options.onNodeDoubleClick === 'function') {
                            options.onNodeDoubleClick(d);
                        }
                    })
                    .on('mouseenter', function(d) {
                        if (typeof options.onNodeMouseEnter === 'function') {
                            options.onNodeMouseEnter(d);
                        }
                        if (typeof options.onInfoChange === 'function') {
                            var info = {
                                type: 1,
                                color: d.properties.color?d.properties.color:class2color(d.labels[0]),
                                node: d
                            }
                            options.onInfoChange(info);
                        }
                    })
                    .on('mouseleave', function(d) {
                        if (typeof options.onNodeMouseLeave === 'function') {
                            options.onNodeMouseLeave(d);
                        }
                        if (typeof options.onInfoChange === 'function') {
                            options.onInfoChange(itemInfo);
                        }
                    })
                    .call(d3.drag()
                        .on('start', dragStarted)
                        .on('drag', dragged)
                        .on('end', dragEnded));
            }

            function appendNodeToGraph() {
                var n = appendNode();

                appendRingToNode(n);
                appendOutlineToNode(n);
                appendTextToNode(n);

                return n;
            }

            function appendOutlineToNode(node) {
                return node.append('circle')
                    .attr('class', options.nodeType==1?'ringType':'outline')
                    .attr('r', options.nodeRadius)
                    .style('fill', function(d) {
                        switch (options.nodeType) {
                            case 0:return d.properties.color ? d.properties.color : class2color(d.labels[0]);
                            case 1:return '#00000000';
                        }
                        return d.properties.color ? d.properties.color : class2color(d.labels[0]);
                    })
                    .style('stroke', function(d) {
                        return d.properties.color ? d3.rgb(d.properties.color).darker(1) : class2darkenColor(d.labels[0]);
                    })
                    .append('title').text(function(d) {
                        return toString(d);
                    });
            }

            function appendRingToNode(node) {
                return node.append('circle')
                    .attr('class', 'ring')
                    .attr('r', options.nodeRadius * 1.16)
                    .append('title').text(function(d) {
                        return toString(d);
                    });
            }

            function appendTextToNode(node) {
                var textLen = (options.nodeRadius-3)*2;
                return  node.append('foreignObject')
                    .attr('x', -textLen/2)
                    .attr('y', -textLen/2)
                    .attr('width', textLen)
                    .attr('height', textLen)
                    .attr('font-size', '10px')
                    .html(function(d) {
                        var nodeText = d.properties.name?d.properties.name:d.labels[0];
                        switch (options.nodeType) {
                            case 0:return "<div style='display:flex;width: 100%;height: 100%;align-items:center;justify-content:center;'><div class='neo4j-node-text'>"+nodeText+"</div></div>";
                            case 1:return "<div style='display:flex;width: 100%;height: 100%;align-items:center;justify-content:center;'><div class='neo4j-ring-type-text'>"+nodeText+"</div></div>";
                        }
                        return "<div style='display:flex;width: 100%;height: 100%;align-items:center;justify-content:center;'><div class='neo4j-node-text'>"+nodeText+"</div></div>";
                    });
            }

            function addNode(label, properties, nodeId) {
                if(!nodeId)
                    nodeId = nodes.length+1;
                if(!label)
                    label = "node"+nodeId;
                if(!properties)
                    properties = {};

                var nodeAdd = [{
                    id: nodeId,
                    labels: [label],
                    properties: properties,
                    x: svg.node().parentElement.parentElement.clientWidth/2,
                    y: svg.node().parentElement.parentElement.clientHeight/2
                }]
                updateNodes(nodeAdd, true);

                simulation.nodes(nodes);
                simulation.alpha(0.1).restart();

                itemInfo = {
                    type: 1,
                    color: properties.color?properties.color:class2color(label),
                    node: nodeAdd[0]
                }
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }

                return  nodeId;
            }
            function updateNodeInfo(nodeId, label, properties) {
                for(var i=0; i<nodes.length; i++){
                    if(nodes[i].id==nodeId)
                    {
                        nodes[i].labels[0]=label;
                        nodes[i].properties=properties;
                        itemInfo = {
                            type: 1,
                            color: properties.color?properties.color:class2color(label),
                            node: nodes[i]
                        }
                        break;
                    }
                }
                nodeSet.each(function(d) {
                    if(d.id==nodeId)
                    {
                        var nodeText = d.properties.name?d.properties.name:d.id;
                        d3.select(this).select(".neo4j-node-text").html(nodeText);
                    }
                });
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }
            }

            function delNode(nodeId) {
                if(!nodeId)
                    return 1;
                for(var i=0; i<relationships.length; i++){
                    if(relationships[i].startNode==nodeId || relationships[i].endNode==nodeId)
                        return 2;
                }

                for(var i=0; i<nodes.length; i++){
                    if(nodes[i].id==nodeId)
                    {
                        nodes.splice(i,1);
                        break;
                    }
                }
                nodeSet = svgNodes.selectAll('.node').data(nodes, function(d) { return d.id; });
                var nodeExit=nodeSet.exit();

                nodeExit.remove();
                simulation.nodes(nodes);
                simulation.alpha(0.1).restart();

                itemInfo = {
                    type: 0,
                    size: size()
                }
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }

                return 0;
            }

            function appendRelationship() {
                return relationship.enter()
                    .append('g')
                    .attr('class', 'relationship')
                    .on('dblclick', function(d) {
                        if (typeof options.onRelationshipDoubleClick === 'function') {
                            options.onRelationshipDoubleClick(d);
                        }
                    })
                    .on('click', function(d) {

                        itemInfo = {
                            type: 2,
                            color: '#aaa',
                            relationship: d
                        }
                        nodeSet.attr('class', "node");
                        relationship.attr('class', "relationship");
                        d3.select(this).attr('class', "relationship selected");
                        if (typeof options.onRelationshipClick === 'function') {
                            options.onRelationshipClick(d);
                        }
                        d3.event.stopPropagation();
                    })
                    .on('mouseenter', function(d) {

                        if (typeof options.onInfoChange === 'function') {
                            var info = {
                                type: 2,
                                color: '#aaa',
                                relationship: d
                            }
                            options.onInfoChange(info);
                        }
                    })
                    .on('mouseleave', function(d) {
                        if (typeof options.onRelationshipMouseLeave === 'function')
                            options.onRelationshipMouseLeave(d);
                        if (typeof options.onInfoChange === 'function')
                            options.onInfoChange(itemInfo);
                    });
            }

            function appendOutlineToRelationship(r) {
                return r.append('path')
                    .attr('class', 'outline')
                    .attr('fill', '#a5abb6')
                    .attr('stroke', 'none');
            }

            function appendOverlayToRelationship(r) {
                return r.append('path')
                    .attr('class', 'overlay');
            }

            function appendTextToRelationship(r) {
                return r.append('text')
                    .attr('class', 'text')
                    .attr('fill', '#000000')
                    .attr('font-size', '8px')
                    .attr('pointer-events', 'none')
                    .attr('text-anchor', 'middle')
                    .text(function(d) {
                        return d.type;
                    });
            }

            function appendRelationshipToGraph() {
                var relationship = appendRelationship(),
                    text = appendTextToRelationship(relationship),
                    outline = appendOutlineToRelationship(relationship),
                    overlay = appendOverlayToRelationship(relationship);

                return {
                    outline: outline,
                    overlay: overlay,
                    relationship: relationship,
                    text: text
                };
            }

            function addRelationship(startNode, endNode, type, properties, relationshipId) {
                if(!relationshipId)
                    relationshipId = relationships.length+1;

                var relationshipAdd = [{
                    id: relationshipId,
                    type: type,
                    startNode: startNode,
                    endNode: endNode,
                    properties: properties,
                    source: startNode,
                    target: endNode,
                    linknum: relationships.length + 1
                }];

                updateRelationships(relationshipAdd, true);
                simulation.force('link').links(relationships);
                simulation.alpha(0.1).restart();

                itemInfo = {
                    type: 2,
                    color: '#aaa',
                    relationship: relationshipAdd[0]
                }
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }

                return  relationshipId;
            }

            function updateRelationshipInfo(relationshipId, startNode, endNode, type, properties) {
                for(var i=0; i<relationships.length; i++){
                    if(relationships[i].id==relationshipId)
                    {
                        relationships[i].type=type;
                        relationships[i].startNode=startNode;
                        relationships[i].endNode=endNode;
                        relationships[i].properties=properties;
                        relationships[i].source=startNode;
                        relationships[i].target=endNode;
                        itemInfo = {
                            type: 2,
                            color: "#aaa",
                            relationship: relationships[i]
                        }
                        break;
                    }
                }
                relationship.each(function(d) {
                    if(d.id==relationshipId)
                    {
                        d3.select(this).select(".text").html(type);
                    }
                });
                simulation.force('link').links(relationships);
                simulation.alpha(0.1).restart();
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }
            }

            function delRelationship(relationshipId) {
                if(!relationshipId)
                    return 1;

                for(var i=0; i<relationships.length; i++){
                    if(relationships[i].id==relationshipId)
                    {
                        relationships.splice(i,1);
                        break;
                    }
                }
                relationship = svgRelationships.selectAll('.relationship')
                    .data(relationships, function(d) { return d.id; });
                var relationshipExit=relationship.exit();

                relationshipExit.remove();
                simulation.force('link').links(relationships);
                simulation.alpha(0.1).restart();

                itemInfo = {
                    type: 0,
                    size: size()
                }
                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }

                return 0;
            }

            function class2color(cls) {
                var color = classes2colors[cls];

                if (!color) {
                    color = options.colors[numClasses % options.colors.length];
                    classes2colors[cls] = color;
                    numClasses++;
                }

                return color;
            }

            function class2darkenColor(cls) {
                return d3.rgb(class2color(cls)).darker(1);
            }

            function clearInfo() {
                info.html('');
            }

            function color() {
                return options.colors[options.colors.length * Math.random() << 0];
            }

            function colors() {
                return [
                    '#68bdf6', // light blue
                    '#6dce9e', // green #1
                    '#faafc2', // light pink
                    '#f2baf6', // purple
                    '#ff928c', // light red
                    '#fcea7e', // light yellow
                    '#ffc766', // light orange
                    '#405f9e', // navy blue
                    '#a5abb6', // dark gray
                    '#78cecb', // green #2,
                    '#b88cbb', // dark purple
                    '#ced2d9', // light gray
                    '#e84646', // dark red
                    '#fa5f86', // dark pink
                    '#ffab1a', // dark orange
                    '#fcda19', // dark yellow
                    '#797b80', // black
                    '#c9d96f', // pistacchio
                    '#47991f', // green #3
                    '#70edee', // turquoise
                    '#ff75ea'  // pink
                ];
            }

            function contains(array, id) {
                var filter = array.filter(function(elem) {
                    return elem.id === id;
                });

                return filter.length > 0;
            }

            function defaultColor() {
                return options.relationshipColor;
            }

            function defaultDarkenColor() {
                return d3.rgb(options.colors[options.colors.length - 1]).darker(1);
            }

            function dragEnded(d) {
                if (!d3.event.active) {
                    simulation.alphaTarget(0);
                }

                if (typeof options.onNodeDragEnd === 'function') {
                    options.onNodeDragEnd(d);
                }
            }

            function dragged(d) {
                stickNode(d);
            }

            function dragStarted(d) {
                if (!d3.event.active) {
                    simulation.alphaTarget(0.15).restart();
                }

                d.fx = d.x;
                d.fy = d.y;

                if (typeof options.onNodeDragStart === 'function') {
                    options.onNodeDragStart(d);
                }
            }

            function init(_selector, _options) {
                merge(options, _options);

                selector = _selector;
                container = d3.select(selector);
                container.html('');

                appendGraph(container);
                simulation = initSimulation();

                if (options.neo4jData) {
                    loadNeo4jData(options.neo4jData);
                } else if (options.neo4jDataUrl) {
                    loadNeo4jDataFromUrl(options.neo4jDataUrl);
                } else if (options.urlGraphData) {
                    loadGraphDataFromUrl(options.urlGraphData);
                } else {
                    nodes = [];
                    relationships = [];
                    itemInfo = {
                        type: 0,
                        size: size()
                    }
                    updateNodesAndRelationships([], []);
                }
            }

            function initSimulation() {
                var simulation = d3.forceSimulation()
                    .force('collide', d3.forceCollide().radius(function(d) {
                        return options.minCollision;
                    }).iterations(2))
                    .force('charge', d3.forceManyBody())
                    .force('link', d3.forceLink().id(function(d) {
                        return d.id;
                    }))
                    .force('center', d3.forceCenter(svg.node().parentElement.parentElement.clientWidth / 2, svg.node().parentElement.parentElement.clientHeight / 2))
                    .on('tick', function() {
                        tick();
                    })
                    .on('end', function() {
                        if (options.zoomFit && !justLoaded) {
                            justLoaded = true;
                            zoomFit();
                        }
                    });

                return simulation;
            }

            function loadNeo4jData() {
                nodes = [];
                relationships = [];

                updateWithNeo4jData(options.neo4jData);
            }

            function loadNeo4jDataFromUrl(neo4jDataUrl) {
                nodes = [];
                relationships = [];

                d3.json(neo4jDataUrl, function(error, data) {
                    if (error) {
                        throw error;
                    }

                    updateWithNeo4jData(data);
                    if (typeof options.onLoadDataFinish === 'function') {
                        options.onLoadDataFinish(size());
                    }
                });
            }

            function loadGraphDataFromUrl(dataUrl) {
                nodes = [];
                relationships = [];

                justLoaded = false;
                d3.json(dataUrl, function(error, data) {
                    if (error) {
                        throw error;
                    }

                    updateWithGraphData(data);
                    simulation.alpha(0.9).restart();
                    if (typeof options.onLoadDataFinish === 'function') {
                        options.onLoadDataFinish(size());
                    }
                });
            }

            function loadGraphData(data) {
                nodes = [];
                relationships = [];

                justLoaded = false;
                updateWithGraphData(data);
                simulation.alpha(0.9).restart();
                if (typeof options.onLoadDataFinish === 'function') {
                    options.onLoadDataFinish(size());
                }
            }

            function getGraphData() {
                var graphData = {
                    "nodes":[],
                    "relationships":[]
                };
                for(var i=0; i<nodes.length; i++)
                {
                    var nodeData = {
                        "id":nodes[i].id,
                        "labels":nodes[i].labels,
                        "properties":nodes[i].properties
                    };
                    graphData.nodes.push(nodeData);
                }
                for(var i=0; i<relationships.length; i++)
                {
                    var nodeData = {
                        "id":relationships[i].id,
                        "startNode":relationships[i].startNode,
                        "endNode":relationships[i].endNode,
                        "type":relationships[i].type,
                        "properties":relationships[i].properties
                    };
                    graphData.relationships.push(nodeData);
                }

                return  graphData;
            }

            function getOutRelationshipCount(nodeId){
                var count = 0;
                relationships.forEach(
                    function(relationship) {
                        if(relationship.startNode==nodeId)
                            count++;
                    }
                );
                return count;
            }

            function merge(target, source) {
                Object.keys(source).forEach(function(property) {
                    target[property] = source[property];
                });
            }

            function neo4jDataToD3Data(data) {
                var graph = {
                    nodes: [],
                    relationships: []
                };

                data.results.forEach(function(result) {
                    result.data.forEach(function(data) {
                        data.graph.nodes.forEach(function(node) {
                            if (!contains(graph.nodes, node.id)) {
                                graph.nodes.push(node);
                            }
                        });

                        data.graph.relationships.forEach(function(relationship) {
                            relationship.source = relationship.startNode;
                            relationship.target = relationship.endNode;
                            graph.relationships.push(relationship);
                        });

                        data.graph.relationships.sort(function(a, b) {
                            if (a.source > b.source) {
                                return 1;
                            } else if (a.source < b.source) {
                                return -1;
                            } else {
                                if (a.target > b.target) {
                                    return 1;
                                }

                                if (a.target < b.target) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }
                        });

                        for (var i = 0; i < data.graph.relationships.length; i++) {
                            if (i !== 0 && data.graph.relationships[i].source === data.graph.relationships[i-1].source && data.graph.relationships[i].target === data.graph.relationships[i-1].target) {
                                data.graph.relationships[i].linknum = data.graph.relationships[i - 1].linknum + 1;
                            } else {
                                data.graph.relationships[i].linknum = 1;
                            }
                        }
                    });
                });

                return graph;
            }

            function graphDataToD3Data(data) {
                var graph = {
                    nodes: [],
                    relationships: []
                };

                data.nodes.forEach(function(node) {
                    if (!contains(graph.nodes, node.id)) {
                        graph.nodes.push(node);
                    }
                });

                data.relationships.forEach(function(relationship) {
                    relationship.source = relationship.startNode;
                    relationship.target = relationship.endNode;
                    graph.relationships.push(relationship);
                });

                data.relationships.sort(function(a, b) {
                    if (a.source > b.source) {
                        return 1;
                    } else if (a.source < b.source) {
                        return -1;
                    } else {
                        if (a.target > b.target) {
                            return 1;
                        }

                        if (a.target < b.target) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });

                for (var i = 0; i < data.relationships.length; i++) {
                    if (i !== 0 && data.relationships[i].source === data.relationships[i-1].source && data.relationships[i].target === data.relationships[i-1].target) {
                        data.relationships[i].linknum = data.relationships[i - 1].linknum + 1;
                    } else {
                        data.relationships[i].linknum = 1;
                    }
                }

                return graph;
            }

            function rotate(cx, cy, x, y, angle) {
                var radians = (Math.PI / 180) * angle,
                    cos = Math.cos(radians),
                    sin = Math.sin(radians),
                    nx = (cos * (x - cx)) + (sin * (y - cy)) + cx,
                    ny = (cos * (y - cy)) - (sin * (x - cx)) + cy;

                return { x: nx, y: ny };
            }

            function rotatePoint(c, p, angle) {
                return rotate(c.x, c.y, p.x, p.y, angle);
            }

            function rotation(source, target) {
                return Math.atan2(target.y - source.y, target.x - source.x) * 180 / Math.PI;
            }

            function size() {
                return {
                    nodes: nodes.length,
                    relationships: relationships.length
                };
            }

            function stickNode(d) {
                d.fx = d3.event.x;
                d.fy = d3.event.y;
            }

            function tick() {
                tickNodes();
                tickRelationships();
            }

            function tickNodes() {
                if (nodeSet) {
                    nodeSet.attr('transform', function(d) {
                        return 'translate(' + d.x + ', ' + d.y + ')';
                    });
                }
            }

            function tickRelationships() {
                if (relationship) {
                    relationship.attr('transform', function(d) {
                        var angle = rotation(d.source, d.target);
                        return 'translate(' + d.source.x + ', ' + d.source.y + ') rotate(' + angle + ')';
                    });

                    tickRelationshipsTexts();
                    tickRelationshipsOutlines();
                    tickRelationshipsOverlays();
                }
            }

            function tickRelationshipsOutlines() {
                relationship.each(function(relationship) {
                    var rel = d3.select(this),
                        outline = rel.select('.outline'),
                        text = rel.select('.text'),
                        bbox = text.node().getBBox(),
                        padding = 3;

                    outline.attr('d', function(d) {
                        var center = { x: 0, y: 0 },
                            angle = rotation(d.source, d.target),
                            textBoundingBox = text.node().getBBox(),
                            textPadding = 5,
                            u = unitaryVector(d.source, d.target),
                            textMargin = { x: (d.target.x - d.source.x - (textBoundingBox.width + textPadding) * u.x) * 0.5, y: (d.target.y - d.source.y - (textBoundingBox.width + textPadding) * u.y) * 0.5 },
                            n = unitaryNormalVector(d.source, d.target),
                            rotatedPointA1 = rotatePoint(center, { x: 0 + (options.nodeRadius + 1) * u.x - n.x, y: 0 + (options.nodeRadius + 1) * u.y - n.y }, angle),
                            rotatedPointB1 = rotatePoint(center, { x: textMargin.x - n.x, y: textMargin.y - n.y }, angle),
                            rotatedPointC1 = rotatePoint(center, { x: textMargin.x, y: textMargin.y }, angle),
                            rotatedPointD1 = rotatePoint(center, { x: 0 + (options.nodeRadius + 1) * u.x, y: 0 + (options.nodeRadius + 1) * u.y }, angle),
                            rotatedPointA2 = rotatePoint(center, { x: d.target.x - d.source.x - textMargin.x - n.x, y: d.target.y - d.source.y - textMargin.y - n.y }, angle),
                            rotatedPointB2 = rotatePoint(center, { x: d.target.x - d.source.x - (options.nodeRadius + 1) * u.x - n.x - u.x * options.arrowSize, y: d.target.y - d.source.y - (options.nodeRadius + 1) * u.y - n.y - u.y * options.arrowSize }, angle),
                            rotatedPointC2 = rotatePoint(center, { x: d.target.x - d.source.x - (options.nodeRadius + 1) * u.x - n.x + (n.x - u.x) * options.arrowSize, y: d.target.y - d.source.y - (options.nodeRadius + 1) * u.y - n.y + (n.y - u.y) * options.arrowSize }, angle),
                            rotatedPointD2 = rotatePoint(center, { x: d.target.x - d.source.x - (options.nodeRadius + 1) * u.x, y: d.target.y - d.source.y - (options.nodeRadius + 1) * u.y }, angle),
                            rotatedPointE2 = rotatePoint(center, { x: d.target.x - d.source.x - (options.nodeRadius + 1) * u.x + (- n.x - u.x) * options.arrowSize, y: d.target.y - d.source.y - (options.nodeRadius + 1) * u.y + (- n.y - u.y) * options.arrowSize }, angle),
                            rotatedPointF2 = rotatePoint(center, { x: d.target.x - d.source.x - (options.nodeRadius + 1) * u.x - u.x * options.arrowSize, y: d.target.y - d.source.y - (options.nodeRadius + 1) * u.y - u.y * options.arrowSize }, angle),
                            rotatedPointG2 = rotatePoint(center, { x: d.target.x - d.source.x - textMargin.x, y: d.target.y - d.source.y - textMargin.y }, angle);

                        return 'M ' + rotatedPointA1.x + ' ' + rotatedPointA1.y +
                            ' L ' + rotatedPointB1.x + ' ' + rotatedPointB1.y +
                            ' L ' + rotatedPointC1.x + ' ' + rotatedPointC1.y +
                            ' L ' + rotatedPointD1.x + ' ' + rotatedPointD1.y +
                            ' Z M ' + rotatedPointA2.x + ' ' + rotatedPointA2.y +
                            ' L ' + rotatedPointB2.x + ' ' + rotatedPointB2.y +
                            ' L ' + rotatedPointC2.x + ' ' + rotatedPointC2.y +
                            ' L ' + rotatedPointD2.x + ' ' + rotatedPointD2.y +
                            ' L ' + rotatedPointE2.x + ' ' + rotatedPointE2.y +
                            ' L ' + rotatedPointF2.x + ' ' + rotatedPointF2.y +
                            ' L ' + rotatedPointG2.x + ' ' + rotatedPointG2.y +
                            ' Z';
                    });
                });
            }

            function tickRelationshipsOverlays() {
                relationshipOverlay.attr('d', function(d) {
                    var center = { x: 0, y: 0 },
                        angle = rotation(d.source, d.target),
                        n1 = unitaryNormalVector(d.source, d.target),
                        n = unitaryNormalVector(d.source, d.target, 50),
                        rotatedPointA = rotatePoint(center, { x: 0 - n.x, y: 0 - n.y }, angle),
                        rotatedPointB = rotatePoint(center, { x: d.target.x - d.source.x - n.x, y: d.target.y - d.source.y - n.y }, angle),
                        rotatedPointC = rotatePoint(center, { x: d.target.x - d.source.x + n.x - n1.x, y: d.target.y - d.source.y + n.y - n1.y }, angle),
                        rotatedPointD = rotatePoint(center, { x: 0 + n.x - n1.x, y: 0 + n.y - n1.y }, angle);

                    return 'M ' + rotatedPointA.x + ' ' + rotatedPointA.y +
                        ' L ' + rotatedPointB.x + ' ' + rotatedPointB.y +
                        ' L ' + rotatedPointC.x + ' ' + rotatedPointC.y +
                        ' L ' + rotatedPointD.x + ' ' + rotatedPointD.y +
                        ' Z';
                });
            }

            function tickRelationshipsTexts() {
                relationshipText.attr('transform', function(d) {
                    var angle = (rotation(d.source, d.target) + 360) % 360,
                        mirror = angle > 90 && angle < 270,
                        center = { x: 0, y: 0 },
                        n = unitaryNormalVector(d.source, d.target),
                        nWeight = mirror ? 2 : -3,
                        point = { x: (d.target.x - d.source.x) * 0.5 + n.x * nWeight, y: (d.target.y - d.source.y) * 0.5 + n.y * nWeight },
                        rotatedPoint = rotatePoint(center, point, angle);

                    return 'translate(' + rotatedPoint.x + ', ' + rotatedPoint.y + ') rotate(' + (mirror ? 180 : 0) + ')';
                });
            }

            function toString(d) {
                var s = d.labels ? d.labels[0] : d.type;

                s += ' (<id>: ' + d.id;

                Object.keys(d.properties).forEach(function(property) {
                    s += ', ' + property + ': ' + JSON.stringify(d.properties[property]);
                });

                s += ')';

                return s;
            }

            function unitaryNormalVector(source, target, newLength) {
                var center = { x: 0, y: 0 },
                    vector = unitaryVector(source, target, newLength);

                return rotatePoint(center, vector, 90);
            }

            function unitaryVector(source, target, newLength) {
                var length = Math.sqrt(Math.pow(target.x - source.x, 2) + Math.pow(target.y - source.y, 2)) / Math.sqrt(newLength || 1);

                return {
                    x: (target.x - source.x) / length,
                    y: (target.y - source.y) / length,
                };
            }

            function updateWithD3Data(d3Data) {
                updateNodesAndRelationships(d3Data.nodes, d3Data.relationships);

                itemInfo = {
                    type: 0,
                    size: size()
                }
            }

            function updateWithNeo4jData(neo4jData) {
                var d3Data = neo4jDataToD3Data(neo4jData);
                updateWithD3Data(d3Data);
            }

            function updateWithGraphData(neo4jData) {
                var d3Data = graphDataToD3Data(neo4jData);
                updateWithD3Data(d3Data);
            }

            function updateNodes(n, sel) {
                Array.prototype.push.apply(nodes, n);

                nodeSet = svgNodes.selectAll('.node')
                    .data(nodes, function(d) { return d.id; });
                var nodeEnter = appendNodeToGraph();
                nodeSet = nodeEnter.merge(nodeSet);
                if(sel){
                    nodeSet.attr('class', "node");
                    relationship.attr('class', "relationship");
                    nodeEnter.attr('class', "node selected");
                }
            }

            function updateNodesAndRelationships(n, r) {
                updateRelationships(r);
                updateNodes(n);

                simulation.nodes(nodes);
                simulation.force('link').links(relationships);
            }

            function updateRelationships(r, sel) {
                Array.prototype.push.apply(relationships, r);

                relationship = svgRelationships.selectAll('.relationship')
                    .data(relationships, function(d) { return d.id; });

                var relationshipEnter = appendRelationshipToGraph();

                relationship = relationshipEnter.relationship.merge(relationship);

                relationshipOutline = svg.selectAll('.relationship .outline');
                relationshipOutline = relationshipEnter.outline.merge(relationshipOutline);

                relationshipOverlay = svg.selectAll('.relationship .overlay');
                relationshipOverlay = relationshipEnter.overlay.merge(relationshipOverlay);

                relationshipText = svg.selectAll('.relationship .text');
                relationshipText = relationshipEnter.text.merge(relationshipText);
                if(sel){
                    nodeSet.attr('class', "node");
                    relationship.attr('class', "relationship");
                    relationshipEnter.relationship.attr('class', "relationship selected");
                }
            }

            function version() {
                return VERSION;
            }

            function zoomFit() {
                var bounds = svg.node().getBBox(),
                    parent = svg.node().parentElement.parentElement,
                    fullWidth = parent.clientWidth,
                    fullHeight = parent.clientHeight,
                    width = bounds.width,
                    height = bounds.height,
                    midX = bounds.x + width / 2,
                    midY = bounds.y + height / 2;

                if (width === 0 || height === 0) {
                    return; // nothing to fit
                }

                svgScale = 0.95 / Math.max(width / fullWidth, height / fullHeight);
                svgTranslate = [fullWidth / 2 - svgScale * midX, fullHeight / 2 - svgScale * midY];

                svg.attr('transform', 'translate(' + svgTranslate[0] + ', ' + svgTranslate[1] + ') scale(' + svgScale + ')');
                svgScale /= eventTransform.k;
                svgTranslate[0] -= eventTransform.x;
                svgTranslate[1] -= eventTransform.y;
            }

            function zoomView(delta) {
                var bounds = svg.node().getBBox();

                if (bounds.width === 0 || bounds.height === 0)
                    return;

                var translate = [eventTransform.x, eventTransform.y];

                translate[0] += svgTranslate[0];
                translate[1] += svgTranslate[1];
                svgScale += delta;
                svg.attr('transform', 'translate(' + translate[0] + ', ' + translate[1] + ') scale(' + eventTransform.k*svgScale + ')');
            }

            function clearGraph(){
                nodes = [];
                relationships = [];
                itemInfo = {
                    type: 0,
                    size: size()
                }
                nodeSet = svgNodes.selectAll('.node').data(nodes, function(d) { return d.id; });
                var nodeExit=nodeSet.exit();
                nodeExit.remove();

                relationship = svgRelationships.selectAll('.relationship')
                    .data(relationships, function(d) { return d.id; });
                var relationshipExit=relationship.exit();
                relationshipExit.remove();

                updateNodesAndRelationships([], []);

                if (typeof options.onInfoChange === 'function') {
                    options.onInfoChange(itemInfo);
                }
            }

            init(_selector, _options);

            return {
                addNode: addNode,
                updateNodeInfo: updateNodeInfo,
                delNode: delNode,
                addRelationship: addRelationship,
                updateRelationshipInfo: updateRelationshipInfo,
                delRelationship: delRelationship,
                zoomFit: zoomFit,
                zoomView: zoomView,
                clearGraph: clearGraph,
                loadGraphDataFromUrl:loadGraphDataFromUrl,
                loadGraphData:loadGraphData,
                getGraphData:getGraphData,
                size: size,
                version: version,
                getOutRelationshipCount:getOutRelationshipCount
            };
        }

        module.exports = Neo4jD3;

    },{}]},{},[1])(1)
});