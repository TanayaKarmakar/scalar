package com.scalar.ds.math.advanced.primenumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 08/04/22
 * @project scalar
 */
public class ListPrimeNumbers {
    private static void listPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= n; i++) {
            int j = i;
            if(isPrime[i]) {
                while(i * j <= n) {
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        listPrimes(n);

        scanner.close();
    }
}
