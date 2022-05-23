package com.scalar.strings.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 21/05/22
 * @project scalar-ds
 */
public class CyclicPermutation {
    private static int solve(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        int n = B.length();
        if(B.equals(A)) {
            map.put(B, map.getOrDefault(B, 0) + 1);
        }

        int k = 1;
        String temp = B;
        while(k < n) {
            String newStr = temp.substring(1) + temp.substring(0, 1);
            map.put(newStr, map.getOrDefault(newStr, 0) + 1);
            temp = newStr;
            k++;
        }

        int count = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getKey().equals(A)) {
                count += entry.getValue();
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "111";
        String B = "111";
        int ans = solve(A, B);

        System.out.println(ans);

        A = "1001";
        B = "0011";
        ans = solve(A, B);

        System.out.println(ans);
    }
}
