package com.scalar.ds.graph.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 18/08/22
 * @project scalar
 */
public class PathInDirectedGraph {
    private static int solve(int A, int[][] B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int t = B[i][1];
            if(!adjList.containsKey(s))
                adjList.put(s, new ArrayList<>());
            adjList.get(s).add(t);
        }
        boolean[] visited = new boolean[A + 1];
        boolean ans = ifPathExist(adjList, 1, A, visited);
        return ans ? 1: 0;
    }

    private static boolean ifPathExist(Map<Integer, List<Integer>> adjList, int source, int dest, boolean[] visited) {
        if(source == dest)
            return true;
        visited[source] = true;
        List<Integer> neighbours = adjList.getOrDefault(source, new ArrayList<>());
        if(!neighbours.isEmpty()) {
            for(Integer nei: neighbours)
                if(!visited[nei]) {
                    if(ifPathExist(adjList, nei, dest, visited))
                        return true;
                }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] B = {{1,4},{2,1},{4,3},{4,5},{2,3},{2,4},{1,5},{5,3},{2,5},{5,1},
                {4,2},{3,1},{5,4},{3,4},{1,3},{4,1},{3,5},{3,2},{5,2}};
        int A = 5;

        int ans = solve(A, B);

        System.out.println(ans);
    }
}
