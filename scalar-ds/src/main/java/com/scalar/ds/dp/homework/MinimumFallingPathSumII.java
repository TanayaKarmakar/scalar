package com.scalar.ds.dp.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 01/08/22
 * @project scalar
 */
public class MinimumFallingPathSumII {
    private static int solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = A[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int min = findMinFromPrevRow(dp, i - 1, j, n);
                dp[i][j] = A[i][j] + min;
            }
        }

        int finalAns = dp[m - 1][0];
        for(int i = 1; i < n; i++) {
            finalAns = Integer.min(finalAns, dp[m - 1][i]);
        }
        return finalAns;
    }

    private static int findMinFromPrevRow(int[][] dp, int row, int colToExclude, int cols) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++) {
            if(i != colToExclude) {
                min = Integer.min(dp[row][i], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
