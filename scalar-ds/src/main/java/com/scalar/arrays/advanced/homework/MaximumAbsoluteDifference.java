package com.scalar.arrays.advanced.homework;

import com.scalar.common.Pair;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class MaximumAbsoluteDifference {
    private static int maxArr(int[] A) {
        int n = A.length;
        int maxAi1 = Integer.MIN_VALUE;
        int minAj1 = Integer.MAX_VALUE;
        int maxAi2 = Integer.MIN_VALUE;
        int minAj2 = Integer.MAX_VALUE;
       for(int i = 0; i < n; i++) {
           int currentAi = (A[i] + i);
           maxAi1 = Integer.max(maxAi1, currentAi);
           minAj1 = Integer.min(minAj1, currentAi);

           currentAi = (A[i] - i);
           maxAi2 = Integer.max(currentAi, maxAi2);
           minAj2 = Integer.min(currentAi, minAj2);
       }

       return Integer.max((maxAi1 - minAj1), (maxAi2 - minAj2));

    }

    public static void main(String[] args) {
        int[] nums = {55, -8, 43, 52, 8, 59, -91, -79, -18, -94};
        int ans = maxArr(nums);

        System.out.println(ans);
    }
}
