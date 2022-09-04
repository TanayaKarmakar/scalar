package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 22/08/22
 * @project scalar
 */
public class TopologicalSort {
    private static int[] solve(int A, int[][] B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] inDeg = new int[A + 1];
        int[] result = new int[A];

        for(int i = 0; i < B.length; i++) {
            int source = B[i][0];
            int dest = B[i][1];
            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(dest);
            inDeg[dest]++;
        }

        int count = 0;
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= A; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                result[j++] = i;
                count++;
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
            for(Integer nei: neighbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0) {
                    q.add(nei);
                    count++;
                    result[j++] = nei;
                }
            }
        }
        return count == A ? result: new int[] {};
    }

    public static void main(String[] args) {
        int A = 8;
        int[][] B = {{1,4},{1,2},{4,2},{4,3},{3,2},{5,2},{3,5},{8,2},{8,6}};

        int[] ans = solve(A, B);

        System.out.println(Arrays.toString(ans));
    }
}
