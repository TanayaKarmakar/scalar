package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 25/08/22
 * @project scalar-ds
 */
public class ConstructionCost {
//    static class Edge implements Comparable<Edge> {
//        int node;
//        int weight;
//
//        public Edge(int node, int weight) {
//            this.node = node;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.weight - o.weight;
//        }
//    }

    private static int findParent(int node, int[] parent) {
        if(parent[node] == node)
            return node;
        parent[node] = findParent(parent[node], parent);
        return parent[node];
    }


    private static int solve(int A, int[][] B) {
        Arrays.sort(B, (b1, b2) -> b1[2] - b2[2]);
        int[] parent = new int[A + 1];
        int[] rank = new int[A + 1];
        int mod = 1000000007;

        for(int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        int targetEdge = A - 1;
        int j = 0;
        int i = 0;
        int totalCost = 0;
        while(i < targetEdge) {
            int[] current = B[j];
            int source = current[0];
            int dest = current[1];
            int weight = current[2];
            int srcParent = findParent(source, parent);
            int dstParent = findParent(dest, parent);
            if(srcParent != dstParent) {
                totalCost = ((totalCost % mod) + (weight % mod)) % mod;
                if(rank[srcParent] < rank[dstParent]) {
                    parent[srcParent] = dstParent;
                } else if(rank[dstParent] < rank[srcParent]) {
                    parent[dstParent] = srcParent;
                } else {
                    parent[dstParent] = srcParent;
                    rank[srcParent]++;
                }
                i++;
            }

            j++;
            if(j == B.length)
                break;
        }
        return totalCost;


//        Map<Integer, List<Edge>> adjList = new HashMap<>();
//        int mod = 1000000007;
//        for(int i = 0; i < B.length; i++) {
//            int source = B[i][0];
//            int dest = B[i][1];
//            int weight = B[i][2];
//
//            if(!adjList.containsKey(source))
//                adjList.put(source, new ArrayList<>());
//            adjList.get(source).add(new Edge(dest, weight));
//            if(!adjList.containsKey(dest))
//                adjList.put(dest, new ArrayList<>());
//            adjList.get(dest).add(new Edge(source, weight));
//        }
//
//        int totalCost = 0;
//        boolean[] visited = new boolean[A + 1];
//
//        int source = B[0][0];
//        List<Edge> neighbors = adjList.getOrDefault(source, new ArrayList<>());
//        PriorityQueue<Edge> pQ = new PriorityQueue<>();
//        visited[source] = true;
//        if(!neighbors.isEmpty()) {
//            for(Edge nei: neighbors) {
//                if(!visited[nei.node]) {
//                    pQ.add(nei);
//                }
//            }
//
//            while(!pQ.isEmpty()) {
//                Edge e = pQ.poll();
//                totalCost = ((totalCost % mod) + (e.weight % mod)) % mod;
//                neighbors = adjList.getOrDefault(e.node, new ArrayList<>());
//                if(!neighbors.isEmpty()) {
//                    for(Edge nei: neighbors) {
//                        if(!visited[nei.node]) {
//                            pQ.add(nei);
//                            visited[nei.node] = true;
//                        }
//                    }
//                }
//            }
//        }
    }

    public static void main(String[] args) {

    }
}
