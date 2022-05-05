package com.scalar.sorting.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class WaveArray {
    private static int[] wave(int[] A) {
        Arrays.sort(A);

        for(int i = 1; i < A.length; i+= 2) {
            int tmp = A[i];
            A[i] = A[i - 1];
            A[i - 1] = tmp;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,1,2};

        System.out.println(Arrays.toString(wave(nums)));

        nums = new int[] {3,4,1,2,5};

        System.out.println(Arrays.toString(wave(nums)));
    }
}
