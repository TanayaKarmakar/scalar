package com.scalar.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class QuickSort {
    private static void quickSort(int[] nums) {
        quickSortRec(nums, 0, nums.length - 1);
    }

    private static void quickSortRec(int[] nums, int start, int end) {
        if(start <= end) {
            int pivotIndx = findPivot(nums, start, end);
            quickSortRec(nums, start, pivotIndx - 1);
            quickSortRec(nums, pivotIndx + 1, end);
        }
    }

    private static int findPivot(int[] nums, int start, int end) {
        int i = start - 1;
        int pivot = nums[end];
        for(int j = start; j <= end; j++) {
            if(nums[j] < pivot) {
                i++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = tmp;
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {5,3,1,2,7,6,11};
        quickSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
