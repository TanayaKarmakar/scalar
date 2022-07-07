package com.scalar.ds.moduloarithmetic.advanced.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/05/22
 * @project scalar
 */
public class ABModulo {
    private static int solve(int A, int B) {
        int min = Integer.min(A, B);
        int max = Integer.max(A, B);
        int diff = max - min;
        if(max % min == 0) {
            if(max % diff == min % diff)
                return Integer.max(min, diff);
            return min;
        }

        return diff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ans = solve(a, b);

        System.out.println(ans);
    }
}
