package com.scalar.hashing.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 13/05/22
 * @project scalar
 */
public class MinDistanceBetweenDuplicatePairs {
    private static int globalMinValue(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int dist = Math.abs(i - map.get(nums[i]));
                ans = Integer.min(dist, ans);
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    private static void minDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> values = entry.getValue();

            if(values.size() > 1) {
                int minDist = Integer.MAX_VALUE;

                for(int i = 1; i < values.size(); i++) {
                    minDist = Integer.min(minDist, values.get(i) - values.get(i - 1));
                }

                System.out.println("Key: " + entry.getKey() + " - Min Distance: " + minDist);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,1,2,3,4,1,6};

        minDistance(nums);

        int ans = globalMinValue(nums);

        System.out.println(ans);
    }
}
