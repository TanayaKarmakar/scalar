package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 03/09/22
 * @project scalar-ds
 */
public class DijkStra {
    static class Edge implements Comparable<Edge> {
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

    private static int[] solve(int A, int[][] B, int C) {
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            int weight = B[i][2];

            if(!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add(new Edge(dest, weight));
            if(!adjList.containsKey(dest)) {
                adjList.put(dest, new ArrayList<>());
            }
            adjList.get(dest).add(new Edge(src, weight));
        }
        dist[C] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        List<Edge> neighbors = adjList.getOrDefault(C, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Edge nei: neighbors) {
                q.add(nei);
                dist[nei.node] = dist[C] + nei.weight;
            }
        }

        while(!q.isEmpty()) {
            Edge e = q.poll();
            neighbors = adjList.getOrDefault(e.node, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Edge nei: neighbors) {
                    int currentDist = dist[e.node] + nei.weight;
                    if(dist[nei.node] > currentDist) {
                        dist[nei.node] = currentDist;
                        q.add(new Edge(nei.node, currentDist));
                    }
                }
            }
        }
        for(int i = 0; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
