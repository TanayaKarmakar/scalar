package com.scalar.arrays;

import java.util.Scanner;

/**
 * @author t0k02w6 on 04/02/22
 * @project scalar-ds
 */
public class CountNumberOfOpenDoors {
    private static boolean isPerfectSquare(int i) {
        int start = 1;
        int end = i;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid * mid == i)
                return true;
            else if(mid * mid > i)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    private static void findOpenDoors(int n) {
        for(int i = 1; i <= n; i++) {
            if(isPerfectSquare(i)) {
                System.out.println(i);
            }
        }
    }


    private static void findOpenDoorsOptimized(int n) {
        int val = (int)Math.sqrt(n);

        for(int i = 1; i <= val; i++) {
            System.out.println((i * i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Open Doors - ");
        findOpenDoors(n);

        System.out.println("Open Doors - Optimized");
        findOpenDoorsOptimized(n);

        scanner.close();
    }
}
