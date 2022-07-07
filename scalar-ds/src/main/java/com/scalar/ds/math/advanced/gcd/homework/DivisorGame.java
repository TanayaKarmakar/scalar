package com.scalar.ds.math.advanced.gcd.homework;


/**
 * @author t0k02w6 on 08/04/22
 * @project scalar
 */
public class DivisorGame {
    private static int solve(int A, int B, int C) {
        int div = (B * C);

        int count = 0;
        for(int i = div; i <= A; i++) {
            if(i % div == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
