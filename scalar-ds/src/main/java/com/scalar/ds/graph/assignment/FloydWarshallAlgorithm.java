package com.scalar.ds.graph.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/09/22
 * @project scalar-ds
 */
public class FloydWarshallAlgorithm {
    private static int[][] solve(int[][] A) {
        int n = A.length;
        int[][] B = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(B[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == -1)
                    B[i][j] = Integer.MAX_VALUE;
                else
                    B[i][j] = A[i][j];
            }
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(B[i][k] == Integer.MAX_VALUE || B[k][j] == Integer.MAX_VALUE)
                        continue;
                    if(B[i][j] > B[i][k] + B[k][j]) {
                        B[i][j] = B[i][k] + B[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(B[i][j] == Integer.MAX_VALUE)
                    B[i][j] = -1;
            }
        }
        return B;
    }

    public static void main(String[] args) {

    }
}
