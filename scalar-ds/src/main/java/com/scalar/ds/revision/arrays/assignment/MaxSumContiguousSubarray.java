package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class MaxSumContiguousSubarray {
    private static int maxSubArray(final int[] A) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

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
