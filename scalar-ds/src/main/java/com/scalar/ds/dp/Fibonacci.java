package com.scalar.ds.dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 27/07/22
 * @project scalar
 */
public class Fibonacci {
    private static int fib(int n) {
        int fib1 = 1;
        int fib2 = 1;
        for(int i = 3; i <= n; i++) {
            int temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return fib2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = fib(n);

        System.out.println(ans);

        scanner.close();
    }
}
