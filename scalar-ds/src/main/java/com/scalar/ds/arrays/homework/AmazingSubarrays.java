package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class AmazingSubarrays {
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u' || ch == 'A'
                || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private static int solve(String A) {
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(isVowel(A.charAt(i)))
                count += (A.length() - i);
        }
        return count % 10003;
    }

    public static void main(String[] args) {
        String str = "ABEC";

        int ans = solve(str);

        System.out.println(ans);
    }
}
