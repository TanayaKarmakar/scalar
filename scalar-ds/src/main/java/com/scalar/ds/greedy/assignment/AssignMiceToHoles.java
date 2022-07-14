package com.scalar.ds.greedy.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class AssignMiceToHoles {
    private static int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int maxTime = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            int diff = Math.abs(A[i] - B[i]);
            maxTime = Integer.max(diff, maxTime);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] mice = {-4,2,3};
        int[] holes = {0, -2, 4};

        int ans = mice(mice, holes);

        System.out.println(ans);
    }
}
