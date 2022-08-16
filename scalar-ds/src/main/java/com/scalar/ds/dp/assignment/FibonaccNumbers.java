package com.scalar.ds.dp.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 30/07/22
 * @project scalar
 */
public class FibonaccNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }

    private static int solve(int n) {
        if(n == 0)
            return 0;
        if(n <= 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
