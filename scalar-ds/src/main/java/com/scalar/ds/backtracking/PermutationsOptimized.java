package com.scalar.ds.backtracking;

import java.util.Arrays;

/**
 * @author t0k02w6 on 22/07/22
 * @project scalar
 */
public class PermutationsOptimized {
    private static void permute(int[] nums) {
        permuteRec(nums, nums.length - 1, 0);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void permuteRec(int[] nums, int right, int left) {
        if(left == nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i = left; i <= right; i++) {
            swap(nums, i, left);
            permuteRec(nums, right, left + 1);
            swap(nums, i, left);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        permute(nums);
    }
}
