package com.scalar.ds.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/01/22
 * @project scalar-ds
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }

        scanner.close();
    }
}
