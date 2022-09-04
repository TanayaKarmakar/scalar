package com.scalar.ds.graph.homework;

import java.util.*;

/**
 * @author t0k02w6 on 03/09/22
 * @project scalar-ds
 */
public class ReversingEdges {
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

    private static int reverseEdges(int A, int[][] B) {
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            if(!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add(new Edge(dest, 0));
        }

        //modifying the graph
        for(int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            boolean connExists = true;
            if(!adjList.containsKey(dest)) {
                adjList.put(dest, new ArrayList<>());
                connExists = false;
            }
            if(!connExists) {
                adjList.get(dest).add(new Edge(src, 1));
                continue;
            }

            connExists = false;
            List<Edge> neighbors = adjList.getOrDefault(dest, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Edge e: neighbors) {
                    if(e.node == src) {
                        connExists = true;
                        break;
                    }
                }
                if(!connExists) {
                    adjList.get(dest).add(new Edge(src, 1));
                }
            }

        }

        int[] dist = new int[A + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        List<Edge> neighbors = adjList.getOrDefault(1, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Edge e: neighbors) {
                dist[e.node] = e.weight;
                pQ.add(e);
            }
        }

        while(!pQ.isEmpty()) {
            Edge e = pQ.poll();
            neighbors = adjList.getOrDefault(e.node, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Edge nei: neighbors) {
                    int currentDist = dist[e.node] + nei.weight;
                    if(dist[nei.node] > currentDist) {
                        dist[nei.node] = currentDist;
                        pQ.add(new Edge(nei.node, currentDist));
                    }
                }
            }
        }

        return dist[A] == Integer.MAX_VALUE ? -1: dist[A];
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{2, 1},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2},
                {2, 3}};

        int ans = reverseEdges(A, B);

        System.out.println(ans);
    }
}
