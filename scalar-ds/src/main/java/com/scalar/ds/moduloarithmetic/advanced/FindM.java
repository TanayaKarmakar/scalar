package com.scalar.ds.moduloarithmetic.advanced;

import java.util.Scanner;

/**
 * @author t0k02w6 on 03/04/22
 * @project scalar
 */
//Find M such that a % M == b % M ( a > b)
public class FindM {
    private static int findM(int a, int b) {
        return a % b == 0 ? b: (a - b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ans = findM(a, b);
        System.out.println(ans);
        scanner.close();
    }
}
