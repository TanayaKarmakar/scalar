package com.scalar.ds.dp.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 30/07/22
 * @project scalar
 */
public class LetsParty {
    private static int solve(int A) {
        if(A <= 2)
            return A;
        int mod = 10003;
        int[] dp = new int[A + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= A; i++) {
            dp[i] = ((dp[i - 1] % mod) + ((((i - 1) % mod) * (dp[i - 2] % mod)) % mod)) % mod;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }
}
