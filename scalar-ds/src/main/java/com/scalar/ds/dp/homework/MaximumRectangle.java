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

        int total = Integer.MIN_VALUE;

        int width = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    if(j == 0) {
                        dp[i][j] = A[i][j];
                    } else {
                        dp[i][j] = 1 + dp[i][j - 1];
                        width = dp[i][j];
                        for(int k = i; k >=0 ; k--) {
                            if(dp[k][j] > 0) {
                                int currentHeight = (i - k) + 1;
                                width = Integer.min(dp[k][j], width);
                                int currentTotal = width * currentHeight;
                                total = Integer.max(total, currentTotal);
                            }
                        }
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1},{0,1,1},{1,0,0}};
        int ans = maximalRectangle(nums);

        System.out.println(ans);
    }
}
