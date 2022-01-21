package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 20/01/22
 * @project scalar-ds
 */
public class MaximumContiguousSubarraySum {
    private static int maxSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = A[0];
        for(int i = 1; i < A.length; i++) {
            if(currentSum < currentSum + A[i])
                currentSum = 0;
            else
                currentSum += A[i];
            maxSum = Integer.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int ans = maxSubArray(nums);

        System.out.println(ans);
    }
}
