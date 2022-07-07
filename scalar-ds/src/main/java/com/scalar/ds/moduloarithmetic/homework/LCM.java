package com.scalar.ds.moduloarithmetic.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 03/02/22
 * @project scalar-ds
 */
public class LCM {
    private static int gcd(int A, int B) {
        if(B == 0)
            return A;
        return gcd(B, A % B);
    }

    private static int LCM(int A, int B) {
        int ans = gcd(A, B);
        return (A * B) / ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ans = LCM(a, b);
        System.out.println(ans);
        scanner.close();
    }
}
