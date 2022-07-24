package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class SubarraySumMatrix {
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int m = A.length;
        int n = A[0].length;
        long[][] prefix = new long[m][n];
        int MOD = 1000000007;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    prefix[i][j] = A[i][j];
                } else {
                    prefix[i][j] = A[i][j] + prefix[i][j - 1];
                }
            }
        }

        for(int j = 0; j < n; j++) {
            for(int i = 1; i < m; i++) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }

        int[] ans = new int[B.length];
        for(int i = 0; i < ans.length; i++) {
            int r1 =B[i] - 1;
            int c1 = C[i] - 1;
            int r2 = D[i] - 1;
            int c2 = E[i] - 1;
            long option1 = A[r2][c2];
            long option2 = (r1 > 0)  ? prefix[r1 - 1][c2]: 0;
            long option3 = (c1 > 0) ? prefix[r2][c1 - 1]: 0;
            long option4 = 0;
            if(r1 > 0 && c1 > 0) {
                option4 =prefix[r1 - 1][c1 - 1];
            }
            long currentValue = option1 - option2 - option3 + option4;
            if(currentValue < 0)
                currentValue += MOD;
            ans[i] = (int)(currentValue % MOD);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};

    }
}
