package com.scalar.ds.graph.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 01/09/22
 * @project scalar-ds
 */
public class EdgeInMST {
    static class Edge implements Comparable<Edge>{
        int indx;
        int src;
        int dest;
        int weight;

        public Edge(int indx, int src, int dest, int weight) {
            this.indx = indx;
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int getParent(int node, int[] parent) {
        if(node == parent[node])
            return node;
        parent[node] = getParent(parent[node], parent);
        return parent[node];
    }

    private static int[] solve(int A, int[][] B) {
        Edge[] edges = new Edge[B.length];
        List<Integer> includedEdgeIndices = new ArrayList<>();
        for(int i = 0; i < B.length; i++) {
            Edge edge = new Edge(i, B[i][0], B[i][1], B[i][2]);
            edges[i] = edge;
        }

        Arrays.sort(edges);

        int[] rank = new int[A + 1];
        int[] parent = new int[A + 1];
        for(int i = 1; i <= A; i++) {
            parent[i] = i;
        }


        int targetEdge = A - 1;
        int i = 0;
        int j = 0;
        while(i < targetEdge) {
            Edge edge = edges[j];
            int src = edge.src;
            int dest = edge.dest;
            int weight = edge.weight;

            int srcParent = getParent(src, parent);
            int destParent = getParent(dest, parent);
            if(srcParent != destParent) {
                includedEdgeIndices.add(edge.indx);
                if(rank[srcParent] < rank[destParent]) {
                    parent[srcParent] = destParent;
                } else if(rank[destParent] < rank[srcParent]) {
                    parent[destParent] = srcParent;
                } else {
                    parent[destParent] = srcParent;
                    rank[srcParent]++;
                }
                i++;
            }
            j++;
            if(j == B.length)
                break;
        }
        int[] result = new int[B.length];
        for(Integer el: includedEdgeIndices) {
            result[el] = 1;
        }
        return result;
    }


//    A : 7
//    B :
//            [
//            [1, 2, 468]
//            [2, 3, 335]
//            [3, 1, 501]
//            [2, 4, 170]
//            [2, 5, 725]
//            [2, 7, 479]
//            [4, 6, 359]
//            [5, 6, 963]
//            ]

    public static void main(String[] args) {
        int A = 7;
        int[][] B = { {1, 2, 468},
        {2, 3, 335},
        {3, 1, 501}, {2,4,170},
                {2,5,725},{2,7,479},{4,6,359},{5,6,963}};

        int[] result = solve(A, B);

        System.out.println(Arrays.toString(result));
    }
}
