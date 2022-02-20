package com.scalar.recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class Factorial {
    private static int fact(int n) {
        if(n == 0 || n == 1)
            return n;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = fact(n);

        System.out.println(ans);

        scanner.close();
    }
}
