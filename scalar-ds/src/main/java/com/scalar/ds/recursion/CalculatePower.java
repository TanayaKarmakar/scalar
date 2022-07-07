package com.scalar.ds.recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 21/02/22
 * @project scalar
 */
public class CalculatePower {
    private static int result(int a, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return a;
        if(n % 2 == 0)
            return result(a * a, n / 2);
        else
            return a * result(a * a, (n - 1)/2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = result(a, n);
        System.out.println(ans);
        scanner.close();
    }
}
