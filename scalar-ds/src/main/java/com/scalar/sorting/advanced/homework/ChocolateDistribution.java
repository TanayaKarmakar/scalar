package com.scalar.sorting.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class ChocolateDistribution {
    private static int solve(int[] A, int B) {
        Arrays.sort(A);

        int minDiff = Integer.MAX_VALUE;
        int n = A.length;
        for(int i = 0; i <= (n - B); i++) {
            int diff = 0;
            if(B != 0)
                diff = A[i + B - 1] - A[i];
            minDiff = Integer.min(diff, minDiff);
        }
        return minDiff == Integer.MAX_VALUE ? 0: minDiff;
    }

    public static void main(String[] args) {

    }
}
