package com.scalar.ds.math.advanced.primenumbers;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class SmallestPrimeFactor {
    private static int smallestPrimeFactor(int n) {
        int[] isPrime = new int[n + 1];

        for(int i = 2; i <= n; i++) {
            int j = i;
            if(isPrime[i] == 0) {
                isPrime[i] = i;
                while((j * i) <= n) {
                    if(isPrime[j * i] == 0) {
                        isPrime[j * i] = i;
                    }
                    j++;
                }
            }
        }

        return isPrime[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = smallestPrimeFactor(n);

        System.out.println(ans);

    }
}
