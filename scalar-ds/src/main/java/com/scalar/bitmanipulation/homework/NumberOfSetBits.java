package com.scalar.bitmanipulation.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 27/01/22
 * @project scalar
 */
public class NumberOfSetBits {
    private static int numSetBits(int A) {
        int count = 0;
        while(A != 0) {
            if((A & 1) == 1)
                count++;
            A = A >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ans = numSetBits(num);

        System.out.println(ans);
        scanner.close();
    }
}
