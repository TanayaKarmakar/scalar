package com.scalar.ds.graph;

import java.util.*;

/**
 * @author t0k02w6 on 01/09/22
 * @project scalar-ds
 */
class Edge implements Comparable<Edge>{
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class PrimsAlgo {
    private static int totalWeight(int[][] edges, int n) {
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            if(!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            adjList.get(source).add(new Edge(dest, weight));
            if(!adjList.containsKey(dest)) {
                adjList.put(dest, new ArrayList<>());
            }
            adjList.get(dest).add(new Edge(source, weight));
        }

        int sourceNode = 1;
        boolean[] visited = new boolean[n + 1];

        return totalWeightCalc(sourceNode, adjList, visited);
    }

    private static int totalWeightCalc(int sourceNode, Map<Integer, List<Edge>> adjList, boolean[] visited) {
        visited[sourceNode] = true;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        List<Edge> neighbors = adjList.getOrDefault(sourceNode, new ArrayList<>());
        int totalCost = 0;
        if(!neighbors.isEmpty()) {
            for(Edge e: neighbors) {
                if(!visited[e.node]) {
                    pQ.add(e);
                }
            }

            while(!pQ.isEmpty()) {
                Edge edge = pQ.poll();
                if(!visited[edge.node]) {
                    visited[edge.node] = true;
                    totalCost += edge.weight;
                    neighbors = adjList.getOrDefault(edge.node, new ArrayList<>());
                    if(!neighbors.isEmpty()) {
                        for(Edge e: neighbors) {
                            if(!visited[e.node]) {
                                pQ.add(e);
                            }
                        }
                    }
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2,2},{1,5,3},{2,3,6},{3,4,4},{5,4,10}};
        int ans = totalWeight(edges, 5);
        System.out.println(ans);
    }
}
