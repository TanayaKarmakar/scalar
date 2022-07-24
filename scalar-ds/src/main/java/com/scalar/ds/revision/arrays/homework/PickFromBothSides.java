package com.scalar.ds.revision.arrays.homework;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class PickFromBothSides {
    public int solve(int[] A, int B) {
        int left = 0;
        int right = 0;
        int n = A.length;
        int i = 0;

        for(i = 0; i < B; i++) {
            left += A[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int k = 0;
        for(int j = 0; j < B; j++) {
            maxSum = Integer.max(maxSum, left + right);
            left = left - A[i];
            i--;
            right += A[n - 1 - k];
            k++;
        }
        maxSum = Integer.max(maxSum, left + right);
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
