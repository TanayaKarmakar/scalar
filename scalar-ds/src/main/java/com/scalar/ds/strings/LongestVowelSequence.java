package com.scalar.ds.strings;

/**
 * @author t0k02w6 on 20/12/21
 * @project scalar-ds
 */
public class LongestVowelSequence {
    private static String solve(String A) {
        if(A == null || A.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcdye";
        System.out.println(solve(str));
    }
}
