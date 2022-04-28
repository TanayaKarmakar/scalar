package com.scalar.sorting.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class MergeSort {
    private static int[] solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private static void mergeSort(int[] a, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid + 1, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] left = new int[mid - start];
        int[] right = new int[end - mid + 1];

        int i1 = 0;
        for(int i = start; i < mid; i++) {
            left[i1++] = a[i];
        }

        i1 = 0;
        for(int i = mid; i <= end; i++) {
            right[i1++] = a[i];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while(i < left.length) {
            a[k++] = left[i++];
        }

        while(j < right.length) {
            a[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 10, 2, 1, 5};
        nums = solve(nums);

        System.out.println(Arrays.toString(nums));
    }
}
