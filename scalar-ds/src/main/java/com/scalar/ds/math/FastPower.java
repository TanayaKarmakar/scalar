package com.scalar.ds.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/12/21
 * @project scalar-ds
 */
public class FastPower {
    private static long solve(long a, long b, long m) {
        if(b == 0)
            return 1;
        long ans = (a * a) % m;
        if(b % 2 == 0)
            return solve(ans, b / 2, m);
        else
            return (a * solve(ans, (b - 1) / 2, m)) % m;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long m = scanner.nextLong();

        long ans = solve(a, b, m);
        System.out.println(ans);

        scanner.close();
    }
}
