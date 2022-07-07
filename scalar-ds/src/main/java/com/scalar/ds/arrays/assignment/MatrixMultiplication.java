package com.scalar.ds.arrays.assignment;

/**
 * @author t0k02w6 on 25/01/22
 * @project scalar
 */
public class MatrixMultiplication {
    private static int[][] solve(int[][] A, int[][] B) {
        if(A[0].length != B.length)
            return new int[][]{};
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int[][] res = new int[m][p];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < p; j++) {
                for(int k = 0; k < n; k++) {
                    res[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        return res;
    }

    private static void print(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{5,6},{7,8}};

        int[][] res = solve(A, B);
        print(res);
    }
}
