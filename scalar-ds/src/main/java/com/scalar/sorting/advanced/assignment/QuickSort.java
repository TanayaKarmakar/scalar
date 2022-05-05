package com.scalar.sorting.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/05/22
 * @project scalar
 */
public class QuickSort {
    private static int[] solve(int[] A) {
        quickSortRec(A, 0, A.length - 1);
        return A;
    }

    private static void quickSortRec(int[] a, int start, int end) {
        if(start >= end)
            return;
        int pivotIndx = findPivot(a, start, end);
        quickSortRec(a, start, pivotIndx - 1);
        quickSortRec(a, pivotIndx + 1, end);
    }

    private static int findPivot(int[] a, int start, int end) {
        int i = start - 1;
        int pivot = a[end];
        for(int j = start; j <= end; j++) {
            if(a[j] < pivot) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        int tmp = a[i + 1];
        a[i + 1] = a[end];
        a[end] = tmp;

        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 10, 2, 1, 5};
        nums = solve(nums);

        System.out.println(Arrays.toString(nums));
    }
}
