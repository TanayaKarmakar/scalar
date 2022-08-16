package com.scalar.ds.dp.homework;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class MaximumSumWithoutAdjacentElements {
    private static int adjacent(int[][] A) {
        int n = A[0].length;

        int maxSum = 0;
        for(int i = 0; i < 2; i++) {
            int[] dp = new int[n];
            dp[0] = A[i][0];
            if(n > 1) {
                dp[1] = Integer.max(A[i][0], A[i][1]);
                for(int j = 2; j < n; j++) {
                    dp[j] = Integer.max(dp[j - 1], A[i][j] + dp[j - 2]);
                }
            }
            maxSum = Integer.max(maxSum, dp[n - 1]);
        }

        //diagonal
        int[][] dp = new int[2][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = A[0][i];
        }
        dp[1][0] = A[1][0];
        if(n > 1) {
            dp[1][1] = A[1][1];
            for(int i = 2; i < n; i++) {
                dp[1][i] = Integer.max(dp[0][i - 1], A[1][i] + dp[0][i - 2]);
            }
            maxSum = Integer.max(maxSum, dp[1][n - 1]);
        }


        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{74, 37, 82, 1},{66, 38, 16, 1}};
        int ans = adjacent(matrix);

        System.out.println(ans);
    }
}
