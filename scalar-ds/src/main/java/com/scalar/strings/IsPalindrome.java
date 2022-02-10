package com.scalar.strings;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class IsPalindrome {
    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start > end) {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
