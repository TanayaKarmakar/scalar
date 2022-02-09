package com.scalar.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class LongestPalindromicSubstring {
    private static String longestPalindrome(String A) {
        int n = A.length();
        int maxLen = Integer.MIN_VALUE;
        String str = null;

        int i = 0;
        while(i < n) {
            int left = i;
            int right = i;
            while(left >= 0 && right < n && A.charAt(left) == A.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    maxLen = (right - left + 1);
                    str = A.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = (i + 1);
            while(left >=0  && right < n && A.charAt(left) == A.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    maxLen = (right - left + 1);
                    str = A.substring(left, right + 1);
                }
                left--;
                right++;
            }

            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "bb";

        System.out.println(longestPalindrome(str));
    }
}
