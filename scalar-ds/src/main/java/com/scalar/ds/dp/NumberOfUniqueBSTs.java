package com.scalar.ds.dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/08/22
 * @project scalar
 */
public class NumberOfUniqueBSTs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);

        scanner.close();
    }

    private static int solve(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
