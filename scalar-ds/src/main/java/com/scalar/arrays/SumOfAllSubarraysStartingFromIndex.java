package com.scalar.arrays;

/**
 * @author t0k02w6 on 20/01/22
 * @project scalar-ds
 */
public class SumOfAllSubarraysStartingFromIndex {
    private static void sum(int[] nums, int startIndx) {
        int sum = 0;
        for(int i = startIndx; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,3,2,-1,6,8,2};
        int startIndx = 3;
        sum(nums, startIndx);
    }
}
