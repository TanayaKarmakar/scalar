package com.scalar.subsetsubseq;

/**
 * @author t0k02w6 on 02/03/22
 * @project scalar
 */
public class SumOfSubsetsBy2Powern {
    private static int solve(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        return totalSum / 2;
    }

    public static void main(String[] args) {
        int[] nums = {-2,6,4};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
