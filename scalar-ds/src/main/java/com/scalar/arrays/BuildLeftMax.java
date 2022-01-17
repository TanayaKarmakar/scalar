package com.scalar.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class BuildLeftMax {
    private static int[] buildLeftMax(int[] nums) {
        int[] leftMax = new int[nums.length];

        leftMax[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            leftMax[i] = Integer.max(leftMax[i - 1], nums[i]);
        }

        return leftMax;
    }

    public static void main(String[] args) {
        int[] nums = {-3,6,2,4,5,2,8,-9,3,1};

        int[] leftMax = buildLeftMax(nums);

        System.out.println(Arrays.toString(leftMax));
    }
}
