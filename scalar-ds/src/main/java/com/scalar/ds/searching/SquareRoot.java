package com.scalar.ds.searching;

import java.util.Scanner;

/**
 * @author t0k02w6 on 06/05/22
 * @project scalar
 */
public class SquareRoot {
    private static int sqrt(int n) {
        if(n <= 1)
            return n;
        long start = 1;
        long end = n;
        long finalAns = 1;
        while(start <= end) {
            long mid = (start + end) >> 1;
            if(mid * mid == n)
                return (int)mid;
            else if((mid * mid) > n)
                end = mid - 1;
            else {
                finalAns = mid;
                start = mid + 1;
            }
        }
        return (int)finalAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = sqrt(n);

        System.out.println(ans);

        scanner.close();
    }
}
