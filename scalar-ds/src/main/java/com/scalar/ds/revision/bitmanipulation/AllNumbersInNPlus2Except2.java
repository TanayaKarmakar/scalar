package com.scalar.ds.revision.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class AllNumbersInNPlus2Except2 {
    private static int[] solve(int[] nums) {
        int n = nums.length;
        int xorAll = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= (n + 2); i++) {
            xorAll = xorAll ^ i;
        }

        for(int i = 0; i < nums.length; i++) {
            xorAll = xorAll ^ nums[i];
        }

        int k = 0;
        while(((xorAll >> k) & 1) != 1) {
            k++;
        }

        int group1 = 0;
        int group2 = 0;

        for(int i = 1; i <= (n + 2); i++) {
            if(((i >> k) & 1) == 1) {
                group1 = group1 ^ i;
            } else {
                group2 = group2 ^ i;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(((nums[i] >> k) & 1) == 1) {
                group1 = group1 ^ i;
            } else {
                group2 = group2 ^ i;
            }
        }

        return new int[] {group1, group2};
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,4};

        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
