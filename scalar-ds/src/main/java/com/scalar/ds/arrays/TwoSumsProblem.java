package com.scalar.ds.arrays;

import java.util.*;

/**
 * @author t0k02w6 on 13/01/22
 * @project scalar-ds
 */
public class TwoSumsProblem {
    private static int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(k - nums[i]))
                return new int[] {map.get(k - nums[i]), i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {3,-2,1,4,3,6,8};
        int k = 10;

        int[] ans = twoSum(nums, k);

        System.out.println(Arrays.toString(ans));
    }
}
