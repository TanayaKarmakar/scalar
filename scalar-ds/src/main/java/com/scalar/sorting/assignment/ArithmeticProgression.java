package com.scalar.sorting.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/02/22
 * @project scalar-ds
 */
public class ArithmeticProgression {
    private static int solve(int[] A) {
        Arrays.sort(A);

        int prevDifference = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++) {
            int currentDifference = A[i] - A[i - 1];
            if(prevDifference != Integer.MAX_VALUE && currentDifference != prevDifference)
                return 0;
            prevDifference = currentDifference;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
