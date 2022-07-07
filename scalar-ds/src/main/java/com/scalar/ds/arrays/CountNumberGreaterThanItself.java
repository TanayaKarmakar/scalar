package com.scalar.ds.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class CountNumberGreaterThanItself {

    private static int count2(int[] nums) {
        if(nums.length <= 1)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i])
                count++;
        }
        return count;
    }

    //best one
    private static int count3(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            max = Integer.max(nums[i], max);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < max)
                count++;
        }
        return count;
    }

    private static int count1(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,-2,6,8,4,8,5};

        int count = count1(nums);

        System.out.println("Approach1 - " + count);

        count = count3(nums);

        System.out.println("Approach3 - " + count);

        count = count2(nums);

        System.out.println("Approach2 - " + count);
    }
}
