package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class MainDiagonalSum {
    private static int solve(final int[][] A) {
        int n = A.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += A[i][i];
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
