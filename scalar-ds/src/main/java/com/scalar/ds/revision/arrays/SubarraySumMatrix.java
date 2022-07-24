package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 23/07/22
 * @project scalar
 */
public class SubarraySumMatrix {
    private static int subarraySumMatrix(int[][] matrix, int r1, int c1, int r2, int c2) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                prefix[i][j] += prefix[i][j - 1] + matrix[i][j];
            }
        }

        for(int j = 0; j < n; j++) {
            for(int i = 1; i < m; i++) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }

        System.out.println("prefix[" + r2 +"][" + c2 + "]" + "-" + prefix[r2][c2]);
        System.out.println("prefix[" + r2 +"][" + (c1 - 1) + "]" + "-" + prefix[r2][c1 - 1]);
        System.out.println("prefix[" + (r1 - 1) +"][" + c2 + "]" + "-" + prefix[r1 - 1][c2]);
        System.out.println("prefix[" + (r1 - 1) +"][" + (c1 - 1) + "]" + "-" + prefix[r1 - 1][c1 - 1]);

        int ans = prefix[r2][c2] - prefix[r2][c1 - 1] - prefix[r1 - 1][c2] + prefix[r1 - 1][c1 - 1];
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int r1 = 2;
        int c1 = 2;
        int r2 = 3;
        int c2 = 3;

        int ans = subarraySumMatrix(matrix, r1, c1, r2,c2);
        System.out.println(ans);
    }
}
