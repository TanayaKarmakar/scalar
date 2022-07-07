package com.scalar.ds.arrays.advanced;

/**
 * @author t0k02w6 on 26/03/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartAtZeroRow {
    private static int maxSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] sum = new int[n];

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[j] += matrix[i][j];
            }

            int currentSum = 0;
            for(int j = 0; j < n; j++) {
                currentSum += sum[j];
                maxSum = Integer.max(maxSum, currentSum);
                if(currentSum < 0)
                    currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

    }
}
