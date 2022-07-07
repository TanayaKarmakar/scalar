package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 23/01/22
 * @project scalar-ds
 */
public class MaxSubarraySumOfLengthK {
    private static int solve(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        while(left < nums.length - k) {
            maxSum = Integer.max(maxSum, sum);
            sum -= nums[left];
            right++;
            sum += nums[right];
            left++;
        }
        maxSum = Integer.max(maxSum, sum);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-3,4,-2,5,3,-2,8,2,-1,4};
        int k = 5;

        int maxSum = solve(nums, k);

        System.out.println(maxSum);
    }
}
