package com.scalar.ds.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class ReverseString {
    private static String solve(String A) {
        String[] words = A.split("\\s+");

        int start = 0;
        int end = words.length - 1;
        while(start < end) {
            String tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length - 1; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[words.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";

        String ans = solve(str);

        System.out.println(ans);
    }
}
