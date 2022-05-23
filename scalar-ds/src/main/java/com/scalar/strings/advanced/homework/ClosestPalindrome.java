package com.scalar.strings.advanced.homework;

/**
 * @author t0k02w6 on 21/05/22
 * @project scalar-ds
 */
public class ClosestPalindrome {
    private static String solve(String A) {
        int n = A.length();
        int start = 0;
        int end = n - 1;
        int nDiff = 0;

        while(start < end) {
            if(A.charAt(start) != A.charAt(end))
                nDiff++;
            if(nDiff > 1)
                return "NO";
            start++;
            end--;
        }

        if(start == end && nDiff == 0)
            nDiff++;

        if(nDiff == 1)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {

    }
}
