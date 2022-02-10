package com.scalar.sorting.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/02/22
 * @project scalar-ds
 */
public class NobleInteger {
    private static int solve(int[] nums) {
        int[] noble = new int[nums.length];
        Arrays.sort(nums);

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] == nums[i + 1])
                noble[i] = noble[i + 1];
            else
                noble[i] = (nums.length - i - 1);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == noble[i])
                count++;
        }

        return count > 0 ? 1: -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,2};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
