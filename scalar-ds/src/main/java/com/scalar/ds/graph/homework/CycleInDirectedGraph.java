package com.scalar.ds.graph.homework;

import java.util.*;

/**
 * @author t0k02w6 on 04/09/22
 * @project scalar-ds
 */
public class CycleInDirectedGraph {
    private static int solve(int A, int[][] B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] inDeg = new int[A + 1];
       // boolean[] visited = new boolean[A + 1];
        for(int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];

            if(!adjList.containsKey(src))
                adjList.put(src, new ArrayList<>());
            adjList.get(src).add(dest);
            inDeg[dest]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < inDeg.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())
            return 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    inDeg[nei]--;
                    if(inDeg[nei] == 0) {
                        count++;
                        q.add(nei);
                    }
                }
            }
        }
        return count == A ? 0: 1;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {  {1, 2} ,
        {4, 1},
        {2, 4},
        {3, 4},
        {5, 2},
        {1, 3} };

        int ans = solve(A, B);

        System.out.println(ans);

    }
}
