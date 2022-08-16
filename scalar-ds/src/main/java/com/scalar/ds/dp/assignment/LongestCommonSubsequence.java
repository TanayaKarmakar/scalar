package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 03/08/22
 * @project scalar
 */
public class LongestCommonSubsequence {
    private static int solve(String A, String B) {
        if(A.length() == 0 || B.length() == 0)
            return 0;
        int m = A.length();
        int n = B.length();
        int[][] lcs = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Integer.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }

    public static void main(String[] args) {

    }
}
