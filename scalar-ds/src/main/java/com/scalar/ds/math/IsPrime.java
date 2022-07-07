package com.scalar.ds.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/01/22
 * @project scalar-ds
 */
public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int val = (int)Math.sqrt(num);

        int i = 2;
        boolean isPrime = true;
        while(i <= val) {
            if(num % i == 0) {
                System.out.println("NO");
                isPrime = false;
                break;
            }
            i++;
        }

        if(isPrime)
            System.out.println("YES");
        scanner.close();
    }
}
