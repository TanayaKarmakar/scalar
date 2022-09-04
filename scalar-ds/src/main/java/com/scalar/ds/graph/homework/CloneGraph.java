package com.scalar.ds.graph.homework;

import java.util.*;

/**
 * @author t0k02w6 on 03/09/22
 * @project scalar-ds
 */
public class CloneGraph {
    static class UndirectedGraphNode {
       int label;
       List<UndirectedGraphNode> neighbors;
       public UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };



    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        populateNodeMap(node, nodeMap, visited);
        visited.clear();
        populateEdges(nodeMap, node, visited);
        return nodeMap.get(node.label);
    }

    private static void populateEdges(Map<Integer, UndirectedGraphNode> nodeMap, UndirectedGraphNode node, Set<Integer> visited) {
        visited.add(node.label);
        List<UndirectedGraphNode> neighbors = node.neighbors;
        for(UndirectedGraphNode nei: neighbors) {
            nodeMap.get(node.label).neighbors.add(nodeMap.get(nei.label));
        }

        for(UndirectedGraphNode nei: neighbors) {
            if(!visited.contains(nei.label))
                populateEdges(nodeMap, nei, visited);
        }
    }

    private static void populateNodeMap(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap, Set<Integer> visited) {
        if(!visited.contains(node.label)) {
            visited.add(node.label);
            nodeMap.put(node.label, new UndirectedGraphNode(node.label));
        }
        List<UndirectedGraphNode> neighbors = node.neighbors;
        if(!neighbors.isEmpty()) {
            for(UndirectedGraphNode nei: neighbors) {
                if(!visited.contains(nei.label))
                    populateNodeMap(nei, nodeMap, visited);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(703);
        node.neighbors.add(new UndirectedGraphNode(43));
        node.neighbors.add(new UndirectedGraphNode(279));
        node.neighbors.add(new UndirectedGraphNode(703));

        UndirectedGraphNode node1 = new UndirectedGraphNode(43);
        node1.neighbors.add(new UndirectedGraphNode(279));
        node1.neighbors.add(new UndirectedGraphNode(703));

        UndirectedGraphNode node2= new UndirectedGraphNode(279);
        node2.neighbors.add(new UndirectedGraphNode(43));
        node2.neighbors.add(new UndirectedGraphNode(279));
        node2.neighbors.add(new UndirectedGraphNode(703));

        UndirectedGraphNode res = cloneGraph(node);


    }
}
