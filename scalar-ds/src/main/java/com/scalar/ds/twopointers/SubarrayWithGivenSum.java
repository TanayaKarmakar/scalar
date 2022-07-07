package com.scalar.ds.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class SubarrayWithGivenSum {
    private static int[] sum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if(prefixSum == k)
                return new int[] {0, i};
            if(map.containsKey(prefixSum - k)) {
                int start = map.get(prefixSum - k) + 1;
                int end = i;
                return new int[] {start, end};
            }
            map.put(prefixSum, i);
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {1,3,15,10,20,23,3};
        int k = 48;

        int[] ans = sum(nums, k);

        System.out.println(Arrays.toString(ans));
    }
}
