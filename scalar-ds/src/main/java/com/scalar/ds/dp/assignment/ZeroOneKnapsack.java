package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 14/08/22
 * @project scalar
 */
public class ZeroOneKnapsack {
    private static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n + 1][C + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= B[i - 1]) {
                   dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - B[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[n][C];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10,20,30};
        int totalWeight = 50;

        int ans = solve(values, weights, totalWeight);

        System.out.println(ans);
    }
}
