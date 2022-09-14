package com.scalar.ds.dp.homework;

/**
 * @author t0k02w6 on 06/08/22
 * @project scalar
 */
public class MaximumRectangle {
    private static int maximalRectangle(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];

        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    dp[i][j] = (j == 0 ? 1: 1 + dp[i][j - 1]);
                    int width = dp[i][j];
                    for(int k = i; k >= 0; k--) {
                        width = Integer.min(width, dp[k][j]);
                        total = Integer.max(total, width * (i - k + 1));
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,0},{1,1,1}};
        int ans = maximalRectangle(nums);

        System.out.println(ans);
    }
}
