package com.scalar.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/04/22
 * @project scalar
 */
public class InsertionSort {
    private static void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int tmp = nums[i];
            int k = i - 1;
            while(k >= 0 && nums[k] > tmp) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = tmp;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {5,8,1,3,15,7,2};
        sort(nums);
    }
}
