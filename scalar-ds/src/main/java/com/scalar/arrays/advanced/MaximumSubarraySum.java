package com.scalar.arrays.advanced;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class MaximumSubarraySum {
    private static int[] maxSum(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndx = -1;
        int endIndx = -1;
        int finalStart = -1;
        int finalEnd = -1;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (startIndx == -1) {
                startIndx = i;
                finalStart = startIndx;
            }
            if(currentSum > maxSum) {
                maxSum = currentSum;
                endIndx = i;
                finalEnd = endIndx;
            }
            if(currentSum < 0) {
                currentSum = 0;
                finalStart = startIndx;
                finalEnd = endIndx;
                startIndx = -1;
                endIndx = -1;
            }
        }
        return new int[]{maxSum, finalStart, finalEnd};
    }

    public static void main(String[] args) {
        int[] nums = {1,-4,5,7,11,13,-59};
        int[] ans = maxSum(nums);

        System.out.println("MaxSum - " + ans[0]);
        System.out.println("StartIndx - " + ans[1]);
        System.out.println("EndIndx - " + ans[2]);
    }
}
