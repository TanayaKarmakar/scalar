package com.scalar.ds.arrays.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class MaximumNonNegativeSubarray {
    private static int[] maxNonNegativeSubarray(int[] nums) {
        int sl = -1;
        int el = -1;
        int sg = -1;
        int eg = -1;
        long currentSum = 0;
        long maxSum = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                currentSum += nums[i];
                if(sl == -1)
                    sl = i;
                el = i;
            } else {
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    sg = sl;
                    eg = el;
                } else if(currentSum == maxSum) {
                    if((el - sl + 1) > (eg - sg + 1)) {
                        eg = el;
                        sg = sl;
                    }
                }
                sl = -1;
                el = -1;
                currentSum = 0;
            }
        }
        if(currentSum > maxSum) {
            maxSum = currentSum;
            sg = sl;
            eg = el;
        } else if(currentSum == maxSum) {
            if((el - sl + 1) > (eg - sg + 1)) {
                eg = el;
                sg = sl;
            }
        }
        if(sg == -1)
            return new int[]{};
        return Arrays.copyOfRange(nums, sg, eg + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1477171087 };
        int[] finalResult = maxNonNegativeSubarray(nums);

        System.out.println(Arrays.toString(finalResult));
    }
}
