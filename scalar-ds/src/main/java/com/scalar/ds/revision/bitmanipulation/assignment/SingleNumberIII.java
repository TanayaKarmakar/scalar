package com.scalar.ds.revision.bitmanipulation.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class SingleNumberIII {
    private static int[] solve(int[] nums) {
        int group1 = 0;
        int group2 = 0;
        int xorAll = 0;

        for(int i = 0; i < nums.length; i++) {
            xorAll = xorAll ^ nums[i];
        }

        int k = 0;
        while(((xorAll >> k) & 1) == 0) {
            k++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(((nums[i] >> k) & 1) == 1) {
                group1 = group1 ^ nums[i];
            } else {
                group2 = group2 ^ nums[i];
            }
        }
        return new int[] {Integer.min(group1, group2), Integer.max(group1, group2)};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 4};
        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
