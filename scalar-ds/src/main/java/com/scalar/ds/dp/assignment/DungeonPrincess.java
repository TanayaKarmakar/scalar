package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 05/08/22
 * @project scalar
 */
public class DungeonPrincess {
    private static int calculateMinimumHP(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = A[m - 1][n - 1] <= 0 ? 1 + Math.abs(A[m - 1][n - 1]) : 1;


        for(int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] - A[m - 1][i];
            if(dp[m - 1][i] <= 0)
                dp[m - 1][i] = 1;
        }

        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] - A[i][n - 1];
            if(dp[i][n - 1] <= 0)
                dp[i][n - 1] = 1;
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Integer.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j];
                if(dp[i][j] < 0)
                    dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] A = {{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        int ans = calculateMinimumHP(A);

        System.out.println(ans);
    }
}
