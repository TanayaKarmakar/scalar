package com.scalar.ds.strings;

/**
 * @author t0k02w6 on 10/02/22
 * @project scalar
 */
public class LengthOfLongestPalindromicSubstring {
    private static int length(String str) {
        int n = str.length();

        int i = 0;
        int maxlen = Integer.MIN_VALUE;
        while(i < n) {
            int left = i;
            int right = i;
            while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if(maxlen < (right - left + 1)) {
                    maxlen = (right - left + 1);
                }
                left--;
                right++;
            }

            right = i + 1;
            left = i;
            while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if(maxlen < (right - left + 1)) {
                    maxlen = (right - left + 1);
                }
                left--;
                right++;
            }
            i++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String str = "abcb";

        int ans = length(str);

        System.out.println(ans);
    }
}
