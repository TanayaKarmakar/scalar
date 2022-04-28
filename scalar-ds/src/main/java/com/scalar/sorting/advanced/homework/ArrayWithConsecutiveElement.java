package com.scalar.sorting.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class ArrayWithConsecutiveElement {
    private static int solve(int[] A) {
        Arrays.sort(A);

        int n = A.length;
        for(int i = 1; i < n; i++) {
            if(A[i] != A[i - 1] + 1)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
