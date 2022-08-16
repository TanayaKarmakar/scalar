package com.scalar.ds.dp.assignment;

/**
 * @author t0k02w6 on 01/08/22
 * @project scalar
 */
public class LongestIncreasingSubsequence {
    private static int lis(final int[] A) {
        int n = A.length;
        int[] lis = new int[n];

        lis[0] = 1;

        int maxValue = 1;
        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[j] < A[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxValue = Integer.max(maxValue, lis[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {

    }
}
