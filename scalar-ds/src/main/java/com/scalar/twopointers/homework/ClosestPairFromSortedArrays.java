package com.scalar.twopointers.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 22/05/22
 * @project scalar-ds
 */
public class ClosestPairFromSortedArrays {
    private static int[] solve(int[] A, int[] B, int C) {
        int m = A.length;
        int n = B.length;
        int i = 0;
        int j = n - 1;

        int diff = Integer.MAX_VALUE;
        int iIndx = -1;
        int jIndx = -1;
        while(i < m && j >= 0) {
            int sum = A[i] + B[j];
            int currentDiff = Math.abs(sum - C);
            if(currentDiff <= diff) {
                if(currentDiff == diff) {
                    if(iIndx == -1) {
                        iIndx = i;
                        jIndx = j;
                    } else if(iIndx == i) {
                        jIndx = Integer.min(jIndx, j);
                    } else if(jIndx == j) {
                        iIndx = Integer.min(iIndx, i);
                    }
                } else {
                    iIndx = i;
                    jIndx = j;
                }
                diff = currentDiff;
            }
            if(sum > C)
                j--;
            else
                i++;
        }
        return new int[]{A[iIndx], B[jIndx]};
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6, 8};
        int C = 9;

        int[] ans = solve(A, B, C);

        System.out.println(Arrays.toString(ans));

    }
}
