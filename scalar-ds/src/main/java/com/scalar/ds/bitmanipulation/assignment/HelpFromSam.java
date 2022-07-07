package com.scalar.ds.bitmanipulation.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 28/01/22
 * @project scalar
 */
public class HelpFromSam {
    private static int solve(int A) {
        if(A == 0)
            return 0;
        int count = 0;
        int tmp = A;

        while(tmp != 0) {
            if((tmp & 1) == 1) {
                count++;
                tmp--;
            } else {
                tmp = tmp >> 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();

        int ans = solve(A);

        System.out.println(ans);

        scanner.close();
    }
}
