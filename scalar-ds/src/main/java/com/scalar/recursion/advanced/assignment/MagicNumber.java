package com.scalar.recursion.advanced.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 16/04/22
 * @project scalar
 */
public class MagicNumber {
    private static int solve(int A) {
        if(A <= 9) {
            if(A == 1)
                return 1;
            else
                return 0;
        }
        return solve(sumOfDigits(A));
    }

    private static int sumOfDigits(int A) {
        if(A == 0)
            return 0;
        int r = A % 10;
        return r + sumOfDigits(A / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);
    }
}
