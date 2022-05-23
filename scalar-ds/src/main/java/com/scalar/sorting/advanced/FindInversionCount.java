package com.scalar.sorting.advanced;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class FindInversionCount {
    private static int count = 0;

    private static int inversionCount(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i = 0;
        int j = 0;
        for(int i1 = start; i1 <= mid; i1++) {
            left[i++] = nums[i1];
        }

        for(int i2 = mid + 1; i2 <= end; i2++) {
            right[j++] = nums[i2];
        }

        int k = start;
        i = 0;
        j = 0;
        while(i < n1 && j < n2) {
            if(left[i] > right[j]) {
                count += (n1 - i);
                nums[k++] = right[j++];
            } else {
                nums[k++] = left[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,3,8,15,6,12,2,18,7,1};

        int ans = inversionCount(nums);
        System.out.println(ans);
    }
}
