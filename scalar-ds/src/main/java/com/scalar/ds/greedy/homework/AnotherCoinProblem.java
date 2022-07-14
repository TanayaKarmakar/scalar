package com.scalar.ds.greedy.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class AnotherCoinProblem {
    private static int solve(int A) {
        int k = 0;
        while((int)Math.pow(5, k) <= A) {
            k++;
        }
        k--;
        int count = 0;

        while(A > 0) {
            while(k >= 0 && A < (int)Math.pow(5, k))
               k--;
            A = A - (int)Math.pow(5, k);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ans = solve(num);

        System.out.println(ans);
        scanner.close();
    }
}
