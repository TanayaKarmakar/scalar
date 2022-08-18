package com.scalar.ds.graph.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 18/08/22
 * @project scalar
 */
public class FirstDepthFirstSearch {
    private static int solve(int[] A, final int B, final int C) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 1; i < A.length; i++) {
            if(!adjList.containsKey(A[i]))
                adjList.put(A[i], new ArrayList<>());
            adjList.get(A[i]).add(i + 1);
        }
        boolean[] visited = new boolean[A.length + 1];
        boolean ans = isPathExists(adjList, C, B, visited);
        return ans ? 1: 0;
    }

    private static boolean isPathExists(Map<Integer, List<Integer>> adjList, int source, int dest, boolean[] visited) {
        if(source == dest)
            return true;
        visited[source] = true;
        List<Integer> neighbours = adjList.getOrDefault(source, new ArrayList<>());
        if(!neighbours.isEmpty()) {
            for (Integer nei: neighbours) {
                if(isPathExists(adjList, nei, dest, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
