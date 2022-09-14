package com.scalar.ds.revision.strings.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 10/09/22
 * @project scalar-ds
 */
public class PeriodOfAStringKMP {
    private static int solve(String A) {
        StringBuilder newSb = new StringBuilder();
        newSb.append(A);
        newSb.append(A);

        String newStr = newSb.toString();
        int n = newStr.length();
        int[] lps = new int[n];
        int j = 0;
        int i = 1;
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

        System.out.println(Arrays.toString(lps));

        int m = A.length();
        for(i = 0; i < n; i++) {
            if(lps[i] >= m)
                return (i - m + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        String str = "abababababb";
        int ans = solve(str);

        System.out.println(ans);
    }
}
