package com.scalar.bitmanipulation.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 31/03/22
 * @project scalar
 */
public class SingleNumberIII {
    private static int[] findTwoSingleNumbers(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int setBit = 0;
        for(setBit = 0; setBit < 32; setBit++) {
            if((xor & (1 << setBit)) > 0)
                break;
        }

        int group1Xor = 0;
        int group2Xor = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & (1 << setBit)) > 0) {
                group1Xor = group1Xor ^ nums[i];
            } else {
                group2Xor = group2Xor ^ nums[i];
            }
        }
        return new int[] {group1Xor, group2Xor};
    }

    public static void main(String[] args) {
        int[] nums = {3,4,6,8,4,3};
        int[] ans = findTwoSingleNumbers(nums);

        System.out.println(Arrays.toString(ans));
    }
}
