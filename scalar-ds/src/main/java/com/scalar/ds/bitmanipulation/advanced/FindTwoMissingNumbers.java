package com.scalar.ds.bitmanipulation.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 31/03/22
 * @project scalar
 */
public class FindTwoMissingNumbers {
    private static int[] findMissing(int[] nums) {
        int xorAll = 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= (n + 2); i++) {
            xorAll = xorAll ^ i;
            list.add(i);
        }

        for(int i = 0; i < n; i++) {
            xorAll = xorAll ^ nums[i];
            list.add(nums[i]);
        }

        int setBit = 0;
        for(setBit = 0; setBit < 32; setBit++) {
            if((xorAll & (1 << setBit)) > 0)
                break;
        }

        int xorGroup1 = 0;
        int xorGroup2 = 0;
        for(Integer el: list) {
            if((el & (1 << setBit)) > 0) {
                xorGroup1 = xorGroup1 ^ el;
            } else {
                xorGroup2 = xorGroup2 ^  el;
            }
        }
        return new int[] {xorGroup1, xorGroup2};
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,4};
        int[] ans = findMissing(nums);

        System.out.println(Arrays.toString(ans));
    }
}
