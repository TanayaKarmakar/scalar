package com.scalar.ds.moduloarithmetic.assignment;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class DivisibilityBy8 {
    private static int solve(String A) {
        String str = A;
        if(A.length() > 3) {
            str = A.substring(A.length() - 3);
        }
        int num = 0;
        int i = 0;
        while(i < str.length()) {
            num = num * 10 + Integer.parseInt(str.charAt(i) + "");
            i++;
        }

        return num % 8 == 0 ? 1: 0;
    }

    public static void main(String[] args) {
        String str = "4560";

        int ans = solve(str);

        System.out.println(ans);
    }
}
