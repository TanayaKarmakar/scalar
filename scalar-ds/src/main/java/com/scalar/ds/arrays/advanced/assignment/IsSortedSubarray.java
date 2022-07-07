package com.scalar.ds.arrays.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class IsSortedSubarray {
    private static int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] prefixSorted = new int[n];

        prefixSorted[0] = 0;
        for(int i = 1; i < n; i++) {
            if(A[i - 1] < A[i]) {
                prefixSorted[i] = prefixSorted[i - 1] == -1 ? (i - 1): prefixSorted[i - 1];
            } else {
                prefixSorted[i] = -1;
            }
        }

        int[] ans = new int[B.length];
        for(int i = 0; i < B.length; i++) {
            int l = B[i][0] - 1;
            int r = B[i][1] - 1;
            if((prefixSorted[r] <= l && prefixSorted[r] >= 0) || l == r)
                ans[i] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-9, -30, 28, 14, -10, 16, 14, -6, -25};
        int[][] B = {{3,8},{1,1},{7,8}};

        int[] ans = solve(A, B);

        System.out.println(Arrays.toString(ans));
    }
}
