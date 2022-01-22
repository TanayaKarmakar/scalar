package com.scalar.arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class MaximumColumnWiseSum {
    public static void main(String[] args) {
        int[][] mat = {{3,8,9,2},{1,2,3,6},{4,10,11,13}};

        long maxSum = 0;
        for(int j = 0; j < mat[0].length; j++) {
            long currentSum = 0;
            for(int i = 0; i < mat.length; i++) {
                currentSum += mat[i][j];
            }
            maxSum = Long.max(currentSum, maxSum);
        }

        System.out.println("Maximum Column wise sum - " + maxSum);
    }
}
