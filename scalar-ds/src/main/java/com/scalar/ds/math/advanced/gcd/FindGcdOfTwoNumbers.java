package com.scalar.ds.math.advanced.gcd;

import java.util.Scanner;

/**
 * @author t0k02w6 on 07/04/22
 * @project scalar
 */
public class FindGcdOfTwoNumbers {
    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ans = gcd(Math.abs(a), Math.abs(b));

        System.out.println(ans);

        scanner.close();
    }
}
