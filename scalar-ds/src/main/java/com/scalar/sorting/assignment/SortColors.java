package com.scalar.sorting.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/02/22
 * @project scalar-ds
 */
public class SortColors {
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static int[] sortColors(int[] A) {
        int low = 0;
        int mid = 0;
        int high = A.length - 1;

        while(mid <= high) {
            int val = A[mid];
            if(val == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if(val == 1)
                mid++;
            else {
                swap(A, mid, high);
                high--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] nums = {0};

        System.out.println(Arrays.toString(sortColors(nums)));
    }
}
