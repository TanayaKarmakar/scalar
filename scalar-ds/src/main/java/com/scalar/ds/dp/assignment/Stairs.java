package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 30/07/22
 * @project scalar
 */
public class Stairs {
    private static int climbStairs(int A) {
        if(A <= 2)
            return A;
        int[] dp = new int[A + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[A];
    }

    public static void main(String[] args) {

    }
}
