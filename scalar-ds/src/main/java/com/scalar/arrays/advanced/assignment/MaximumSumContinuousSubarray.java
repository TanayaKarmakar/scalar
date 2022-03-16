package com.scalar.arrays.advanced.assignment;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class MaximumSumContinuousSubarray {
    private static int maxSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;
        for(int i = 0; i < A.length; i++) {
            currentSum += A[i];
            maxSum = Integer.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
