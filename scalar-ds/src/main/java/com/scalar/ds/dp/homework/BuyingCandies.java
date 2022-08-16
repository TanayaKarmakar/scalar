package com.scalar.ds.dp.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 14/08/22
 * @project scalar
 */
public class BuyingCandies {
    private static int solve(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        int[] dp = new int[D + 1];

        for(int i = 1; i <= D; i++) {
            int maxSweetNess = 0;
            for(int j = 0; j < n; j++) {
                if(i >= C[j]) {
                    maxSweetNess = Integer.max(maxSweetNess, B[j] * A[j] + dp[i - C[j]]);
                }
            }
            dp[i] = maxSweetNess;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[D];
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {2,2,10};
        int[] C = {2,3,9};
        int D = 8;

        int ans = solve(A, B, C, D);

        System.out.println(ans);

        A = new int[] {2};
        B = new int[] {5};
        C = new int[] {10};
        D = 99;

        ans = solve(A, B, C, D);

        System.out.println(ans);
    }
}
