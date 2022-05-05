package com.scalar.sorting.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class ReversePairs {
    private static int count = 0;

    private static int solve(int[] A) {
        count = 0;
        mergeSortRec(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        return count;
    }

    private static void mergeSortRec(int[] a, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSortRec(a, start, mid);
        mergeSortRec(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int j = mid + 1;
        for(int i = start; i <= mid; i++) {
            while(j <= end && a[i] > 2L * a[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        int n1 = (mid - start + 1);
        int n2 = (end - mid);

        int[] l = new int[n1];
        int[] r = new int[n2];

        int i1 = 0;
        for(int i = start; i <= mid; i++) {
            l[i1++] = a[i];
        }

        i1 = 0;
        for(int i = mid + 1; i <= end; i++) {
            r[i1++] = a[i];
        }

        i1 = start;
        int i = 0;
        j = 0;
        while(i < n1 && j < n2) {
            if(l[i] < r[j]) {
                a[i1++] = l[i++];
            } else {
                a[i1++] = r[j++];
            }
        }

        while(i < n1)
            a[i1++] = l[i++];
        while(j < n2)
            a[i1++] = r[j++];
    }

    public static void main(String[] args) {
        int[] nums = {40,25,19,12,9,6,2};
        int count = solve(nums);

        System.out.println(count);
    }
}
