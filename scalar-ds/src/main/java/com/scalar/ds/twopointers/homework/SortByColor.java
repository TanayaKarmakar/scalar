package com.scalar.ds.twopointers.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class SortByColor {
    private static int[] sortColors(int[] A) {
        int n = A.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high) {
            int el = A[mid];
            switch (el) {
                case 0:
                    swap(A, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(A, mid, high);
                    high--;
                    break;
            }
        }
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 1, 2};
        nums = sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}
