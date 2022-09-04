package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 22/08/22
 * @project scalar
 */
public class CycleInUndirectedGraph {
    private static int solve(int A, int[][] B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int d = B[i][1];

            if(!adjList.containsKey(s))
                adjList.put(s, new ArrayList<>());
            adjList.get(s).add(d);
            if(!adjList.containsKey(d))
                adjList.put(d, new ArrayList<>());
            adjList.get(d).add(s);
        }

        Set<Integer> visited = new HashSet<>();
        for(int i = 1; i <= A; i++) {
            if(!visited.contains(i)) {
                boolean isCycle = isCycleRec(adjList, i, -1, visited);
                if(isCycle)
                    return 1;
            }
        }
        return 0;
    }

    private static boolean isCycleRec(Map<Integer, List<Integer>> adjList, int current, int parent, Set<Integer> visited) {
        visited.add(current);
        List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Integer nei: neighbors) {
                if((visited.contains(nei) && nei != parent))
                    return true;
                if(!visited.contains(nei)) {
                    if(isCycleRec(adjList, nei, current, visited))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1,2},{1,3},{2,3},{1,4},{4,5}};

        int ans = solve(A, B);

        System.out.println(ans);
    }
}
