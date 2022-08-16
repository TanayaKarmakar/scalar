package com.scalar.ds.dp;

/**
 * @author t0k02w6 on 11/08/22
 * @project scalar
 */
public class LongestPalindromicSubsequence {
    private static int solve(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for(int l = 2; l <= n; l++) {
            int i = 0;
            int j = l - 1;
            while(j < n) {
                if(str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j - 1]);
                }
                i++;
                j++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "abdeba";

        int ans = solve(str);

        System.out.println(ans);
    }
}
