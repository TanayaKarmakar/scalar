package com.scalar.recursion.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class SumOfDigits {
    private static int solve(int A) {
        if(A == 0)
            return 0;
        return (A % 10) + solve(A / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }
}
