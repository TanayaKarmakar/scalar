package com.scalar.ds.revision.bitmanipulation;

import java.util.Arrays;

/**
 * @author t0k02w6 on 09/08/22
 * @project scalar
 */
public class AllNumbersOccursTwiceExceptTwo {
    private static int[] solve(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int k = 0;
        int group1 = 0;
        int group2 = 0;
        while(((xor >> k) & 1) != 1) {
            k++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(((nums[i] >> k) & 1) == 1)
                group1 = group1 ^ nums[i];
            else
                group2 = group2 ^ nums[i];
        }
        return new int[] {group1, group2};
    }

    public static void main(String[] args) {
        int[] nums = {3,4,6,4,3,8};
        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
