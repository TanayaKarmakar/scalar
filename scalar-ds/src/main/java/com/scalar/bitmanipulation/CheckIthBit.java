package com.scalar.bitmanipulation;

import java.util.Scanner;

/**
 * @author t0k02w6 on 29/01/22
 * @project scalar
 */
public class CheckIthBit {
    private static String checkIthBit(int n, int i) {
        int tmp = n >> i;
        return (tmp & 1) == 1 ? "Yes": "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = scanner.nextInt();

        System.out.println(checkIthBit(n, i));

        scanner.close();
    }
}
