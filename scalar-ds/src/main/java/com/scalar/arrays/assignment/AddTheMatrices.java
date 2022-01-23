package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class AddTheMatrices {
    private static int[][] solve(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
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
        int[][] A = {{1,2,3}, {4,5,6},{7,8,9}};
        int[][] B = {{9,8,7},{6,5,4},{3,2,1}};

        int[][] result = solve(A, B);

        print(result);
    }
}
