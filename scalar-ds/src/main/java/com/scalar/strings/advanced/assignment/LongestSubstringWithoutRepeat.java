package com.scalar.strings.advanced.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 25/05/22
 * @project scalar
 */
public class LongestSubstringWithoutRepeat {
    private static int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int n = A.length();

        int maxLen = 1;
        while(right < n) {
            while(right < n && !set.contains(A.charAt(right))) {
                set.add(A.charAt(right));
                right++;
            }
            maxLen = Integer.max(maxLen, right - left);
            set.remove(A.charAt(left));
            left++;
        }
        maxLen = Integer.max(maxLen, right - left);
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "dadbc";
        int ans = lengthOfLongestSubstring(str);

        System.out.println(ans);
    }
}
