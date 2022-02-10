package com.scalar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 06/02/22
 * @project scalar-ds
 */
public class NobleInteger {
    private static List<Integer> nobleIntegers(int[] nums) {
        Arrays.sort(nums);

        int[] count = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                count[i] = i;
            } else {
                count[i] = count[i - 1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == count[i]) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-10,1,1,1,4,4,4,7,10};

        List<Integer> res = nobleIntegers(nums);

        System.out.println(res);
    }
}
