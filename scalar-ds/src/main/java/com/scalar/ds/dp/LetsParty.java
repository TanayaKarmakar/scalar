package com.scalar.ds.dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 30/07/22
 * @project scalar
 */
public class LetsParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int ans = ways(n);

        System.out.println("Ways - "+ ans);
        scanner.close();
    }

    private static int ways(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
}
