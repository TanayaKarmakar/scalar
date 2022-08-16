package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class MaximumAbsoluteDifference {
    private static int maxArr(int[] A) {
        if(A.length == 1)
            return A[0];
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < A.length; i++) {
            max1 = Integer.max(max1, A[i] + i);
            min1 = Integer.min(min1, A[i] + i);
            max2 = Integer.max(max2, A[i] - i);
            min2 = Integer.min(min2, A[i] - i);
        }

        return Integer.max(max1 - min1, max2 - min2);
    }

    public static void main(String[] args) {

    }
}
