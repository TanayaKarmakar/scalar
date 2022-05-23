package com.scalar.hashing.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
public class ShaggyAndDistances {
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]))
                minDist = Integer.min(minDist, i - map.get(A[i]));
            map.put(A[i], i);
        }

        return minDist == Integer.MAX_VALUE ? -1: minDist;
    }

    public static void main(String[] args) {

    }
}
