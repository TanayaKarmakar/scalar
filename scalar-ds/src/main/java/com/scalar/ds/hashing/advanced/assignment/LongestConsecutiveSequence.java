package com.scalar.ds.hashing.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
public class LongestConsecutiveSequence {
    private static int longestConsecutive(final int[] A) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], false);
        }

        int maxLen = 1;
        for(int i = 0; i < A.length; i++) {
            int k = A[i];
            int count = 0;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                k++;
                count++;
            }

            k = A[i];
            k--;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                k--;
                count++;
            }

            maxLen = Integer.max(maxLen, count);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int ans = longestConsecutive(nums);

        System.out.println(ans);
    }
}
