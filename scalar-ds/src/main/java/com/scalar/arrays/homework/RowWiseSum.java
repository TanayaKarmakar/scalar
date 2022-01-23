package com.scalar.arrays.homework;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class RowWiseSum {
    private static int[] solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[] sum = new int[m];

        for(int i = 0; i < m; i++) {
            int currentSum = 0;
            for(int j = 0; j < n; j++) {
                currentSum += A[i][j];
            }
            sum[i] = currentSum;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
