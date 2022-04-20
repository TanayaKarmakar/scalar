package com.scalar.math.advanced.primenumbers;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class PrimeFactorization {
    private static int countPrimeFactors(int n) {
        int[] spf = new int[n + 1];

        spf[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(spf[i] == 0) {
                spf[i] = i;
                int j = i;
                while((i * j) <= n) {
                    if(spf[i * j] == 0)  {
                        spf[i * j] = i;
                    }
                    j++;
                }
            }
        }

        int count = 2;
        int temp = n;
        while(spf[temp] != temp) {
            int smallestPrimeFactor = spf[temp];
            count++;
            temp = temp / smallestPrimeFactor;
        }

        //count += 2;
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = countPrimeFactors(n);

        System.out.println("Answer - "+ ans);
        scanner.close();
    }
}
