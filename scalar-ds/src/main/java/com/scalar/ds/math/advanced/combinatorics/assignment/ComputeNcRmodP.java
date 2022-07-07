package com.scalar.ds.math.advanced.combinatorics.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 11/04/22
 * @project scalar
 */
public class ComputeNcRmodP {
    private static long modInverse(long x, long p) {
        return pow(x, p - 2, p);
    }

    private static long pow(long x, long n, long m) {
        if(n == 0)
            return 1;
        long number = pow(x, n / 2, m);
        if(n % 2 == 0)
            return ((number % m) * (number % m)) % m;
        else
            return ((x * number) % m * (number % m)) % m;
    }


    private static int solve(int A, int B, int C) {
        long[] fact = new long[A + 1];

        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= A; i++) {
            fact[i] = (i * (fact[i - 1] % C)) % C;
        }

        long part1 = fact[A];
        long part2 = modInverse(fact[A - B], C);
        long part3 = modInverse(fact[B], C);

        return (int)(((((part1 % C) * (part2 % C)) % C) * part3) % C);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int ans = solve(a, b, c);

        System.out.println(ans);

        scanner.close();
    }
}
