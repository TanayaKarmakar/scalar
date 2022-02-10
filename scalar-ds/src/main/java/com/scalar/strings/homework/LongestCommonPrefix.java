package com.scalar.strings.homework;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] A) {
        String str = A[0];
        for(int i = 1; i < A.length; i++) {
            int i1 = 0;
            int j1 = 0;
            while(i1 < str.length() && j1 < A[i].length()
                    && str.charAt(i1) == A[i].charAt(j1)) {
                i1++;
                j1++;
            }
            str = str.substring(0, i1);
        }
        return str;
    }

    public static void main(String[] args) {
        String[] str = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(str));

        str = new String[]{"abab", "ab", "abcd"};
        System.out.println(longestCommonPrefix(str));
    }
}
