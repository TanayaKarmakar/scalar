package com.scalar.bitmanipulation.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 27/01/22
 * @project scalar
 */
public class ReverseBits {
    private static long reverse(long a) {
        long b = 0;

        long tmp = a;
        for(int i = 0; i < 32; i++){
            b = b << 1;
            b = b | (tmp & 1);
            tmp = tmp >> 1;
        }

        return b;
    }

//    private static long reverse1(long a) {
//        long mask1 = a & 0X0000ffff;
//        long mask2 = a & 0Xffff0000;
//
//        mask1 = mask1 << 16;
//        mask2 = mask2 >> 16;
//        return mask1 | mask2;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long ans = reverse(num);

        System.out.println(ans);
        scanner.close();
    }
}
