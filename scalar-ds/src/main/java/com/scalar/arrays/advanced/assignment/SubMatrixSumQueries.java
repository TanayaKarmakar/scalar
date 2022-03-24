package com.scalar.arrays.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class SubMatrixSumQueries {
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int m = A.length;
        int n = A[0].length;
        long[][] prefix = new long[m][n];
        int MOD = 1000000007;

        //row wise sum
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += A[i][j];
                prefix[i][j] = sum;
            }
        }

        //column wise sum
        for(int j = 0; j < n; j++) {
            for(int i = 1; i < m; i++) {
                prefix[i][j] = prefix[i][j] + prefix[i - 1][j];
            }
        }

        int[] ans = new int[B.length];

        for(int i = 0; i < ans.length; i++) {
            int r1 = B[i] - 1;
            int c1 = C[i] - 1;
            int r2 = D[i] - 1;
            int c2 = E[i] - 1;

            long option1 = (r1 > 0) ?  prefix[r1 - 1][c2]: 0;
            long option2 = (c1 > 0) ? prefix[r2][c1 - 1]: 0;
            long option3 = (r1 > 0 && c1 > 0) ? prefix[r1 - 1][c1 - 1]: 0;

            long sum = (prefix[r2][c2] - option1 - option2 + option3) % MOD;
            if(sum < 0)
                sum = sum + MOD;
            ans[i] = (int) sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[] B = {1,2};
        int[] C = {1,1};
        int[] D = {2,3};
        int[] E = {2,3};

        int[] ans = solve(matrix, B, C, D, E);

        System.out.println(Arrays.toString(ans));
    }
}
