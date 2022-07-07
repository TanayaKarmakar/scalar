package com.scalar.ds.hashing.advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 18/05/22
 * @project scalar
 */
public class KSimilarStrings {
    private static boolean canForm(String str, int k) {
        int n = str.length();
        if(n % k != 0)
            return false;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            if(entry.getValue() % k != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
