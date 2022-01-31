package com.scalar.bitmanipulation.assignment;

/**
 * @author t0k02w6 on 26/01/22
 * @project scalar
 */
public class SingleNumber {
    private static int singleNumber(final int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
