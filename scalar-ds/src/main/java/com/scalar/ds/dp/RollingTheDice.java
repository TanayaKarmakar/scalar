package com.scalar.ds.dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 30/07/22
 * @project scalar
 */
public class RollingTheDice {
    private static int solveRec(int n) {
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        int ans = 0;
        for(int i = 1; i <= 6; i++) {
            ans += solveRec(n - i);
        }
        return ans;
    }

    private static int solve(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solveRec(n);

        System.out.println("Recursion - " + ans);

        ans = solve(n);

        System.out.println("Bottom UP - " + ans);

        scanner.close();
    }
}
