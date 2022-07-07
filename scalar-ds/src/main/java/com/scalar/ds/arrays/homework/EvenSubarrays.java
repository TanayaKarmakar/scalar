package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class EvenSubarrays {
    private static String solve(int[] A) {
        if(A.length % 2 != 0)
            return "NO";

        boolean isPossible = (A[0] % 2 == 0 && A[A.length - 1] % 2 == 0);

        return isPossible ? "YES": "NO";

    }

    public static void main(String[] args) {

    }
}
