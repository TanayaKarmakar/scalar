package com.scalar.ds.arrays.advanced;

/**
 * @author t0k02w6 on 23/03/22
 * @project scalar
 */
public class RangeQueryMatrix {
    private static int rangeQuery(int[][] matrix, int r1, int c1, int r2, int c2) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m][n];

        int sum = 0;

        //row wise sum
        for(int i = 0; i < m; i++) {
            sum = 0;
            for(int j = 0; j < n; j++) {
                sum += matrix[i][j];
                prefix[i][j] = sum;
            }
        }

        //column wise sum
        for(int j = 0; j < n; j++) {
            sum = prefix[0][j];
            for(int i = 1; i < m; i++) {
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }

        int result = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int ans = rangeQuery(matrix, 1, 1, 2,2);

        System.out.println(ans);
    }
}
