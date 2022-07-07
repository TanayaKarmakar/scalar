package com.scalar.ds.arrays.advanced;

/**
 * @author t0k02w6 on 26/03/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartAtAnyRow {
    private static int maxSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = Integer.MIN_VALUE;

        for(int r1 = 0; r1 < m; r1++) {
            int[] sum = new int[n];
            for(int r2 = r1; r2 < m; r2++) {
                for(int c = 0; c < n; c++) {
                    sum[c] += matrix[r2][c];
                }

                int currentSum = 0;
                for(int c = 0; c < n; c++) {
                    currentSum += sum[c];
                    max = Integer.max(max, currentSum);

                    if(currentSum < 0)
                        currentSum = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,-4,1,5,-1,2},{1,3,2,-7,3,3},{0,-1,1,3,4,-7},{1,-1,-6,4,-4,6}};

        int max = maxSum(matrix);
        System.out.println(max);
    }
}
