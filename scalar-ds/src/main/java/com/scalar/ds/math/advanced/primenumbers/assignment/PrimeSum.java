package com.scalar.ds.math.advanced.primenumbers.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class PrimeSum {
    private static int[] primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= A; i++) {
            int j = i;
            if(isPrime[i]) {
                while(i * j <= A) {
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }

        for(int i = 2; i <= A; i++) {
            if(isPrime[i] && isPrime[A - i])
                return new int[]{i, A - i};
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int n = 1048574;
        System.out.println(Arrays.toString(primesum(n)));
    }
}
