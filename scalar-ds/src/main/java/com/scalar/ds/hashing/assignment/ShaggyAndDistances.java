package com.scalar.ds.hashing.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class ShaggyAndDistances {
    private static int solve(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            if(!map.containsKey(A[i]))
                map.put(A[i], new ArrayList<>());
            map.get(A[i]).add(i);
        }

        int minLen = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if(entry.getValue().size() > 1) {
                int currentLen = entry.getValue().get(1) - entry.getValue().get(0);
                minLen = Integer.min(minLen, currentLen);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1: minLen;
    }
}
