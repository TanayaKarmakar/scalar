package com.scalar.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 14/02/22
 * @project scalar-ds
 */
public class CalculateDistinctElements {
    private static void calculateDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int right = 0;
        while(right < k) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
        }

        System.out.println(map.size());

        int left = 0;
        while(right < nums.length) {
           int val = map.get(nums[left]);
           val--;
           if(val == 0) {
               map.remove(nums[left]);
           } else {
               map.put(nums[left], val);
           }
           left++;

           map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
           System.out.println(map.size());
           right++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        calculateDistinct(nums, 2);
    }
}
