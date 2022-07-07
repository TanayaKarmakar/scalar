package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class MinorDiagonalSum {
    public int solve(final int[][] A) {
        int n = A.length;

        int sum = 0;
        for(int i = 0, j = n - 1; (i < n && j >= 0); i++, j--) {
            sum += A[i][j];
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
