package com.scalar.ds.graph.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 20/08/22
 * @project scalar
 */
public class CheckBiPartiteGraph {
    private static boolean isBipartite(int vertex, LinkedList<Integer>[] edges, Set<Integer> visited) {
        Set<Integer>[] sets = new HashSet[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        sets[0].add(0);
        visited.add(vertex);

        while(!q.isEmpty()) {
            int node = q.poll();
            LinkedList<Integer> neighbors = edges[node];
            int value = sets[0].contains(node) ? 0: 1;
            if(Objects.nonNull(neighbors)) {
                for(Integer nei: neighbors) {
                    int toBeAdded = 1 - value;
                    if(!sets[value].contains(nei) && !sets[toBeAdded].contains(nei)) {
                        sets[toBeAdded].add(nei);
                        q.add(nei);
                        visited.add(nei);
                    } else {
                        if(sets[value].contains(nei))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private static int solve(int A, int[][] B) {
        LinkedList<Integer>[] edges = new LinkedList[A];
        Set<Integer> nodes = new HashSet<>();

        for(int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int d = B[i][1];
            if(edges[s] == null) {
                edges[s] = new LinkedList<>();
            }
            edges[s].add(d);

            if(edges[d] == null) {
                edges[d] = new LinkedList<>();
            }
            edges[d].add(s);
            nodes.add(s);
            nodes.add(d);
        }

        Set<Integer> visited = new HashSet<>();
        //int connectedCount = 0;
        for(Integer el: nodes) {
            if(!visited.contains(el)) {
                boolean isBiPartite = isBipartite(el, edges, visited);
                if(!isBiPartite)
                    return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int A = 8;
        int[][] edges = {{5,6},{1,3},{2,4},{4,5}};
        int ans = solve(A, edges);

        System.out.println(ans);
    }
}
