package com.scalar.ds.graph.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 25/08/22
 * @project scalar-ds
 */
public class Batches {
    private static int solve(int A, int[] B, int[][] C, int D) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[A];
        for(int i = 0; i < C.length; i++) {
            int source = C[i][0];
            int dest = C[i][1];
            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(dest);
            if(!adjList.containsKey(dest))
                adjList.put(dest, new ArrayList<>());
            adjList.get(dest).add(source);
        }

        int count = 0;

        for(int i = 0; i < A; i++) {
            if(!visited[i]) {
                int strength = dfs(i+1, adjList, visited, B);
                if(strength >= D)
                    count++;
            }
        }
        return count;
    }

    private static int dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, int[] strength) {
        visited[node - 1] = true;
        int result = strength[node - 1];
        List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
        if(!neighbours.isEmpty()) {
            for(Integer nei: neighbours) {
                if(!visited[nei - 1])
                    result += dfs(nei, adjList, visited, strength);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A = 7;
        int[] B = {1,6,7,2,9,4,5};
        int[][] C = {{1,2},{2,3},{5,6},{6,7}};
        int D = 12;

        int ans = solve(A, B, C, D);

        System.out.println(ans);

    }
}
