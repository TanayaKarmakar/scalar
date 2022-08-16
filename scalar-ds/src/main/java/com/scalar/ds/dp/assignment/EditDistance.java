package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 03/08/22
 * @project scalar
 */
public class EditDistance {
    private static int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Integer.min(dp[i - 1][j], Integer.max(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
