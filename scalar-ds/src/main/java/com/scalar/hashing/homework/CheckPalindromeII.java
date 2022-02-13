package com.scalar.hashing.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class CheckPalindromeII {
    private static int solve(String A) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }

        int countOdd = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if((entry.getValue() & 1) == 1) {
                countOdd++;
            }
        }

        return countOdd <= 1 ? 1: 0;
    }
}
