package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 01/08/22
 * @project scalar
 */
public class UniquePaths {
    private static int uniquePathsWithObstacles(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = A[0][0] == 1 ? 0: 1;

        for(int i = 1; i < n; i++) {
            if(A[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i - 1];
        }

        for(int i = 1; i < m; i++) {
            if(A[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i - 1][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(A[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
        int ans = uniquePathsWithObstacles(nums);

        System.out.println(ans);
    }
}
