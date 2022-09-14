package com.scalar.ds.revision.strings.assignment;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/09/22
 * @project scalar-ds
 */
public class WindowString {
    private static String minWindow(String A, String B) {
        if(A.length() == 0 || B.length() == 0)
            return "";
        Map<Character, Integer> patternMap = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> stringMap = new HashMap<>();
        int required = patternMap.size();
        int formed = 0;
        int left = 0;
        int right = 0;
        int startIndx = -1;
        int endIndx = -1;
        int minLen = -1;
        while(right < A.length()) {
            char ch = A.charAt(right);
            stringMap.put(ch, stringMap.getOrDefault(ch, 0) + 1);
            if(patternMap.containsKey(ch) && patternMap.get(ch) == stringMap.get(ch))
                formed++;

            while(left <= right && required == formed) {
                if(minLen == -1 || minLen > (right - left + 1)) {
                    startIndx = left;
                    endIndx = right;
                    minLen = (right - left + 1);
                }
                ch = A.charAt(left);
                int value = stringMap.get(ch);
                stringMap.put(ch, --value);

                if(patternMap.containsKey(ch) && stringMap.get(ch) < patternMap.get(ch))
                    formed--;
                left++;
            }
            right++;
        }
        return  minLen == -1 ? "": A.substring(startIndx, endIndx + 1);
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";

        String ans = minWindow(A, B);

        System.out.println(ans);
    }
}
