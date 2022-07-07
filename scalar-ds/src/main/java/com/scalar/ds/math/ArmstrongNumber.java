package com.scalar.ds.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/01/22
 * @project scalar-ds
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int i = 1;
        while(i < num) {
            int temp = i;
            int sum = 0;
            while(temp != 0) {
                int r = temp % 10;
                sum += (r * r * r);
                temp = temp/10;
            }

            if(i == sum)
                System.out.println(i);
            i++;
        }
        scanner.close();
    }
}
