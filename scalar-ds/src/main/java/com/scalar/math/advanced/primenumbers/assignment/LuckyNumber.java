package com.scalar.math.advanced.primenumbers.assignment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class LuckyNumber {
    private static int solve(int A) {
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


        int countLuckyNumbers = 0;
        for(int i = 2; i <= A; i++) {
            int countPrimeDiv = 0;
            int countNonPrimeDiv = 0;
            for(int j = 2; j <= i; j++) {
                if(i % j == 0) {
                    if(isPrime[j])
                        countPrimeDiv++;
                    else
                        countNonPrimeDiv++;
                }
            }
            if(countPrimeDiv == 2)
                countLuckyNumbers++;
        }
        return countLuckyNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }
}
