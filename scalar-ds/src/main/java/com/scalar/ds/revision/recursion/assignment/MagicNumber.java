package com.scalar.ds.revision.recursion.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 26/08/22
 * @project scalar-ds
 */
public class MagicNumber {
    private static int solve(int A) {
        if(A <= 9) {
            if(A == 1)
                return 1;
            else
                return 0;
        }
        return solve(sumOfDigits(A)) == 1 ? 1: 0;
    }

    private static int sumOfDigits(int a) {
        if(a <= 9) {
            return a;
        }
        int r = a % 10;
        return r + sumOfDigits(a / 10);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ans = solve(num);

        System.out.println(ans);

        scanner.close();
    }
}
