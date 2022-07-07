package com.scalar.ds.sorting.advanced.homework;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class MaxMod {
    private static int solve(int[] A) {
        int max = A[0];
        int sMax = A[0];
        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                sMax = max;
                max = A[i];
            } else if(A[i] > sMax && A[i] < max)
                sMax = A[i];
        }
        return sMax % max;
    }

    public static void main(String[] args) {

    }
}
