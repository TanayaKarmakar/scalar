package com.scalar.ds.revision.bitmanipulation.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 11/08/22
 * @project scalar
 */
public class MinimumXorValue {
    private static int findMinXor(int[] A) {
        Arrays.sort(A);

        int minXor = Integer.MAX_VALUE;

        for(int i = 0; i < A.length - 1; i++) {
            int currentXor = A[i] ^ A[i + 1];
            minXor = Integer.min(minXor, currentXor);
        }
        return minXor;
    }

    public static void main(String[] args) {

    }
}
