package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class ScalarProduct {
    private static int[][] solve(int[][] A, int B) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                A[i][j] *= B;
            }
        }

        return A;
    }

    public static void main(String[] args) {

    }
}
