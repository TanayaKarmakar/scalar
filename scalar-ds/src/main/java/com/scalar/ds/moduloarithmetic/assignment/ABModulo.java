package com.scalar.ds.moduloarithmetic.assignment;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class ABModulo {
    private static int solve(int A, int B) {
        int max = Integer.max(A, B);
        int min = Integer.min(A, B);
        return (max - min);
    }

    public static void main(String[] args) {

    }
}
