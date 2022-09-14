package com.scalar.ds.graph.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 08/09/22
 * @project scalar-ds
 */
public class SheldonAndPairOfCities {
    private static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int[][] dist = new int[A + 1][A + 1];

        for(int i = 0; i <= A; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < D.length; i++) {
            int src = D[i];
            int dest = E[i];
            int weight = F[i];
            dist[src][dest] = Integer.min(dist[src][dest],weight);
            dist[dest][src] = Integer.min(dist[dest][src],weight);;
        }

        for(int i = 0; i <= A; i++) {
            dist[i][i] = 0;
        }

        for(int k = 1; k <= A; k++) {
            for(int i = 1; i <= A; i++) {
                for(int j = 1; j <= A; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = (dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= A; i++) {
            for(int j = 1; j <= A; j++) {
                if(dist[i][j] == Integer.MAX_VALUE)
                    dist[i][j] = -1;
            }
        }

        int[] result = new int[C];
        for(int i = 0; i < C; i++) {
            int src = G[i];
            int dest = H[i];
            result[i] = dist[src][dest];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
