package com.scalar.ds.dp.homework;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class DiceThrow {
    private static int solve(int A) {
        int[] dp = new int[A + 1];
        int mod = 1000000007;

        dp[0] = 1;
        for(int i = 1; i <= A; i++) {
            int ans = 0;
            for(int j = 1; j <= 6; j++) {
                if(i >= j) {
                    ans = ((ans % mod) + (dp[i - j] % mod)) % mod;
                }
            }
            dp[i] = ans;
        }
        return dp[A];
    }

    public static void main(String[] args) {

    }
}
