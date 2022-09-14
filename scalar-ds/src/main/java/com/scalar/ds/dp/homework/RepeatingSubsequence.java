package com.scalar.ds.dp.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/09/22
 * @project scalar-ds
 */
public class RepeatingSubsequence {
    private static int anytwo(String A) {
        int n = A.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(A.charAt(i) == A.charAt(j) && i != j) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

//        for(int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][0] >= 2 ? 1: 0;
    }

    public static void main(String[] args) {
        String str = "abba";

        int ans = anytwo(str);

        System.out.println(ans);

    }
}
