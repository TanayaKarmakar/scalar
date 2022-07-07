package com.scalar.ds.arrays;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/02/22
 * @project scalar-ds
 */
public class NthMagicalNumber {
    private static int magicalNumber(int n) {
        int k = 1;

        int ans = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ans = ans + (int)Math.pow(5, k);
            }
            n = n >> 1;
            k++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = magicalNumber(n);

        System.out.println(ans);
    }
}
