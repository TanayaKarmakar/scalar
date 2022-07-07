package com.scalar.ds.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class MergeSort {
    private static void mergeSort(int[] nums) {
        mergeSortRec(nums, 0, nums.length - 1);
    }

    private static void mergeSortRec(int[] nums, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSortRec(nums, start, mid);
        mergeSortRec(nums, mid + 1, end);
        merge(nums, start, mid + 1, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] left = new int[mid - start];
        int[] right = new int[end - mid + 1];

        int i1 = 0;
        for(int i = start; i < mid; i++) {
            left[i1++] = nums[i];
        }

        i1 = 0;
        for(int i = mid; i <= end; i++) {
            right[i1++] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i < left.length) {
            nums[k++] = left[i++];
        }
        while(j < right.length) {
            nums[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,3,6,4,1,5};
        mergeSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
