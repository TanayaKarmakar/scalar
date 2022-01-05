package com.scalar.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/01/22
 * @project scalar-ds
 */
public class Summation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = n * (n + 1)/2;

        System.out.println(sum);

        scanner.close();
    }
}
