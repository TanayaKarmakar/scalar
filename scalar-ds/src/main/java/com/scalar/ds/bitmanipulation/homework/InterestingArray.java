package com.scalar.ds.bitmanipulation.homework;

/**
 * @author t0k02w6 on 29/01/22
 * @project scalar
 */
public class InterestingArray {
    private static String solve(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }

        if((result & 1) == 0)
            return "Yes";
        return "No";
    }

    public static void main(String[] args) {

    }
}
