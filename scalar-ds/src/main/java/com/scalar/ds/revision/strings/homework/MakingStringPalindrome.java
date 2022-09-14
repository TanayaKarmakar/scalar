package com.scalar.ds.revision.strings.homework;

/**
 * @author t0k02w6 on 10/09/22
 * @project scalar-ds
 */
public class MakingStringPalindrome {
    private static int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        StringBuilder newSb = new StringBuilder();
        newSb.append(sb);
        newSb.append("$");
        newSb.append(sb.reverse());

        String newStr = newSb.toString();
        int n = newStr.length();
        int[] lps = new int[n];

        int i = 1;
        int j = 0;
        while(i < n) {
            if(newStr.charAt(i) == newStr.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = j;
                    i++;
                }
            }
        }
        return A.length() - lps[n - 1];
    }

    public static void main(String[] args) {
        String str = "abc";
        int ans = solve(str);

        System.out.println(ans);
    }
}
