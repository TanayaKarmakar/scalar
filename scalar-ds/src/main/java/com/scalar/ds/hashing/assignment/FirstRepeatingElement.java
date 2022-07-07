package com.scalar.ds.hashing.assignment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class FirstRepeatingElement {
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
