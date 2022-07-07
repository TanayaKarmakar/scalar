package com.scalar.ds.recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class Fibonacci {
    private static int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = fib(n);

        System.out.println(ans);

        scanner.close();
    }
}
