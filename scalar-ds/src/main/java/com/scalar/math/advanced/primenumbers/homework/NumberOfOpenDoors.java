package com.scalar.math.advanced.primenumbers.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class NumberOfOpenDoors {
    private static int solve(int A) {
        return (int)Math.sqrt(A);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }
}
