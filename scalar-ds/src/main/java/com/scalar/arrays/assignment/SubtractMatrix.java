package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class SubtractMatrix {
    public static int[][] solve(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
