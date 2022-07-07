package com.scalar.ds.arrays.assignment;

/**
 * @author t0k02w6 on 20/01/22
 * @project scalar-ds
 */
public class MaximumContiguousSubarraySum {
    private static int maxSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
//        for(int i = 0; i < A.length; i++) {
//            int currentSum = 0;
//            for(int j = i; j < A.length; j++) {
//                currentSum += A[j];
//                maxSum = Integer.max(maxSum, currentSum);
//            }
//        }

        for(int i = 0; i < A.length; i++) {
            currentSum += A[i];
            maxSum = Integer.max(maxSum, currentSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int ans = maxSubArray(nums);

        System.out.println(ans);
    }
}
