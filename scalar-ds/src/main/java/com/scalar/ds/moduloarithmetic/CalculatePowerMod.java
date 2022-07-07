package com.scalar.ds.moduloarithmetic;

import java.util.Scanner;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class CalculatePowerMod {
    private static int calcPower(int a, int n, int p) {
        int result = 1;
        for(int i = 0; i < n; i++) {
            result = (result * (a % p))%p;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int p = scanner.nextInt();


        int result = calcPower(a, n, p);

        System.out.println(result);

        scanner.close();
    }
}
