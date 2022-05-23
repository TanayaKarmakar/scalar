package com.scalar.strings.advanced;

/**
 * @author t0k02w6 on 20/05/22
 * @project scalar-ds
 */
public class LongestStringWhichIsAPrefixOfAll {
    private static String longestPrefix(String[] strs) {
        String str = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int l1 = 0;
            int l2 = 0;
            while(l1 < str.length() && l2 < strs[i].length() && str.charAt(l1) == strs[i].charAt(l2)) {
                l1++;
                l2++;
            }
            str = str.substring(0, l1);
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = {"axdc", "axbc","axdb"};

        System.out.println(longestPrefix(strs));
    }
}
