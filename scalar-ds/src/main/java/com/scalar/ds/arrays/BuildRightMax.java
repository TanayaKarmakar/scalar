package com.scalar.ds.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class BuildRightMax {
    private static int[] buildRightMax(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Integer.max(nums[i], rightMax[i + 1]);
        }
        return rightMax;
    }

    public static void main(String[] args) {
        int[] nums = {-3,6,2,4,5,2,8,-9,3,1};

        int[] leftMax = buildRightMax(nums);

        System.out.println(Arrays.toString(leftMax));
    }
}
