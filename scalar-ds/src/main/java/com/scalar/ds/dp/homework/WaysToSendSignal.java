package com.scalar.ds.dp.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/08/22
 * @project scalar
 */
public class WaysToSendSignal {
    private static int solve(int A) {
        long[] dp = new long[A + 1];
        int mod = 1000000007;

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= A; i++) {
            dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod)) % mod;
        }

        return (int)dp[A];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();

        int ans = solve(A);

        System.out.println(ans);
        scanner.close();
    }
}
