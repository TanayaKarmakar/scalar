package com.scalar.ds.recursion.assignment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author t0k02w6 on 21/02/22
 * @project scalar
 */
public class MagicNumber {
    private static int sumOfDigits(int a) {
        if(a == 0)
            return 0;
        return (a % 10) + sumOfDigits(a / 10);
    }

    private static int solve(int A) {
        Set<Integer> set = new HashSet<>();
        while(true) {
            int temp = sumOfDigits(A);
            if(temp == 1)
                return 1;
            if(set.contains(temp))
                return 0;
            A = temp;
            set.add(A);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int ans = solve(n);

        System.out.println(ans);
    }
}
