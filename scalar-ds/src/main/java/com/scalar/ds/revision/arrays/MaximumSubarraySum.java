package com.scalar.ds.revision.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class MaximumSubarraySum {
    private static int[] maxSubarraySum1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int startGlobal = -1;
        int endGlobal = -1;
        int startLocal = -1;
        int endLocal = -1;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(startLocal == -1) {
                startLocal = i;
                endLocal = i;
            } else {
                endLocal++;
            }
            if(maxSum < currentSum) {
                maxSum = currentSum;
                startGlobal = startLocal;
                endGlobal = endLocal;
            }
            if(currentSum < 0) {
                currentSum = 0;
                startLocal = -1;
                endLocal = -1;
            }
        }
        return new int[] {startGlobal, endGlobal};
    }

    private static int maxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Integer.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,-4,5,7,11,13,-59};

        int ans = maxSubarraySum(nums);

        System.out.println(ans);

        int[] ansArr = maxSubarraySum1(nums);

        System.out.println(Arrays.toString(ansArr));
    }
}
