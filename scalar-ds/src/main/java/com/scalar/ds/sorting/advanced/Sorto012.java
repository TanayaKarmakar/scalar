package com.scalar.ds.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/05/22
 * @project scalar
 */
public class Sorto012 {
    private static void sort(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while(mid <= high) {
            int el = nums[mid];
            switch (el) {
                case 0:
                    swap(nums, low, mid);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,1,0,0,2,1,0,2,1};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
