package com.scalar.hashing.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class GetSum {
    private static int getSum(int A, int B, int[] C) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < C.length; i++) {
            map.put(C[i], map.getOrDefault(C[i], 0) + 1);
        }

        int sum = 0;
        boolean isPossible = false;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == B) {
                sum += entry.getKey();
                isPossible = true;
            }
        }

        return isPossible? sum: -1;
    }

    public static void main(String[] args) {

    }
}
