package com.scalar.arrays.advanced;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartAtZeroEndAtM {
    private static int maxSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] sum = new int[n];
        for(int j = 0; j < n; j++) {
            int currentRowSum = 0;
            for(int i = 0; i < m; i++) {
                currentRowSum += matrix[i][j];
            }
            sum[j] = currentRowSum;
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < sum.length; i++) {
            currentSum += sum[i];
            maxSum = Integer.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,-3,4},{-5,-6,7,8},{9,10,-11,-12}};

        int ans = maxSum(matrix);

        System.out.println(ans);
    }
}
