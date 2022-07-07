package com.scalar.ds.recursion.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class Fibonacci {
    private static int findAthFibonacci(int A) {
        if(A == 0 || A == 1)
            return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = findAthFibonacci(n);

        System.out.println(ans);

        scanner.close();
    }
}
