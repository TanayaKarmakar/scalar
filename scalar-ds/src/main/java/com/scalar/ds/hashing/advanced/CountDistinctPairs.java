package com.scalar.ds.hashing.advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 13/05/22
 * @project scalar
 */
public class CountDistinctPairs {
    private static void countPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            int count = (value * (value - 1)) / 2;

            System.out.println(entry.getKey() + " : " + count);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,1,2,3,4,1,6};

        countPairs(nums);
    }
}
