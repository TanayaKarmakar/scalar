package com.scalar.ds.graph.assignment;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author t0k02w6 on 25/08/22
 * @project scalar-ds
 */
public class CommutableIslands {
    private static int findParent(int node, int[] parent) {
        if(parent[node] == node)
            return parent[node];
        parent[node] = findParent(parent[node], parent);
        return parent[node];
    }

    private static int solve(int A, int[][] B) {
        Arrays.sort(B, Comparator.comparingInt(b -> b[2]));

        int[] parent = new int[A + 1];
        int[] rank = new int[A + 1];
        int totalCost = 0;

        for(int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        int targetEdge = A - 1;
        int i = 0;
        int j = 0;
        while(i < targetEdge) {
            int[] current = B[j];
            int src = current[0];
            int dest = current[1];
            int weight = current[2];
            int srcParent = findParent(src, parent);
            int destParent = findParent(dest, parent);
            if(srcParent != destParent) {
                if(rank[srcParent] < rank[destParent]) {
                    parent[srcParent] = destParent;
                } else if(rank[destParent] < rank[srcParent]) {
                    parent[destParent] = srcParent;
                } else {
                    parent[destParent] = srcParent;
                    rank[srcParent]++;
                }
                totalCost += weight;
                i++;
            }
            j++;
            if(j == B.length)
                break;
        }
        return totalCost;
    }


    public static void main(String[] args) {

    }
}
