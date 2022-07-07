package com.scalar.ds.arrays.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 23/01/22
 * @project scalar-ds
 */
public class MaximumPositivity {
    private static int[] solve(int[] A) {
        int maxLen = Integer.MIN_VALUE;
        int indx = -1;
        int minIndx = -1;
        int currentLen = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0) {
                indx = -1;
                currentLen = 0;
            } else {
                if(indx == -1)
                    indx = i;
                currentLen++;
                if(currentLen > maxLen) {
                    maxLen = currentLen;
                    minIndx = indx;
                }
            }
        }

        if(minIndx == -1)
            return new int[]{};
        return Arrays.copyOfRange(A, minIndx, minIndx + maxLen);
    }

    public static void main(String[] args) {
        int[] nums = {5,6,-1,7,8};

        System.out.println(Arrays.toString(solve(nums)));

        nums = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(solve(nums)));

        nums = new int[]{-4549634, -3196682, 8455838, -1432628, -263819, -3928366, -5556259, -2114783, 3923939, -4183708 };

        System.out.println(Arrays.toString(solve(nums)));

    }
}
