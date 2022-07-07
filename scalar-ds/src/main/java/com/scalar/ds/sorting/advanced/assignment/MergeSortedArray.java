package com.scalar.ds.sorting.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class MergeSortedArray {
    private static int[] solve(final int[] A, final int[] B) {
        int m = A.length;
        int n = B.length;

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        while(i < m) {
            result[k++] = A[i++];
        }

        while(j < n) {
            result[k++] = B[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {4,7,9};
        int[] B = {2,11,19};

        int[] result = solve(A, B);

        System.out.println(Arrays.toString(result));
    }
}
