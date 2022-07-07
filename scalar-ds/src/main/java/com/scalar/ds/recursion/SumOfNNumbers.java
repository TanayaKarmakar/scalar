package com.scalar.ds.recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class SumOfNNumbers {
    private static int sum(int n) {
        if(n == 1)
            return n;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = sum(n);

        System.out.println(ans);
    }
}
