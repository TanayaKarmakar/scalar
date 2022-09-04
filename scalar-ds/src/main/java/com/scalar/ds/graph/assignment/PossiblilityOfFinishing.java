package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 22/08/22
 * @project scalar
 */
public class PossiblilityOfFinishing {
    private static int solve(int A, int[] B, int[] C) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[A + 1];

        for(int i = 0; i < B.length; i++) {
            int source = B[i];
            int dest = C[i];
            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(dest);
            inDeg[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 1; i <= A; i++) {
            if(inDeg[i] == 0) {
                count++;
                q.add(i);
            }
        }


        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(curr, new ArrayList<>());
            for(Integer nei: neighbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0) {
                    q.add(nei);
                    count++;
                }
            }
        }
        return count == A ? 1: 0;
    }

    public static void main(String[] args) {

    }
}
