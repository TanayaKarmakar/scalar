package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 13/08/22
 * @project scalar
 */
public class UnboundedKnapsack {
    private static int solve(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];

        for(int i = 0; i <= A; i++) {
            int maxPossible = 0;
            for(int j = 0; j < B.length; j++) {
                if(i >= C[j]) {
                    int ans = B[j] + dp[i - C[j]];
                    maxPossible = Integer.max(maxPossible, ans);
                }
            }
            dp[i] = maxPossible;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        int A = 10;
        int[] B = {6, 7};
        int[] C = {5, 5};

        int ans = solve(A, B, C);

        System.out.println(ans);
    }
}
