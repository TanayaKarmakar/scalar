package com.scalar.ds.sorting.advanced.assignment;

/**
 * @author t0k02w6 on 30/04/22
 * @project scalar
 */
public class InversionCount {
    private static long count = 0;
    private static int MOD = 100000007;

    private static void mergeSort(int[] A, int start, int end) {
        if(start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
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

        int i = 0;
        int j = 0;
        i1 = start;
        while(i < n1 && j < n2) {
            if(l[i] < r[j]) {
                a[i1++] = l[i++];
                count += (mid+1) - (start + i);
            } else {
                if(l[i] > r[j])
                    count += (n1 - i);
                a[i1++] = r[j++];
            }
        }

        while(i < n1) {
            a[i1++] = l[i++];
        }

        while(j < n2) {
            a[i1++] = r[j++];
        }
    }

    private static int solve(int[] A) {
        count = 0;
        mergeSort(A,0, A.length - 1);
        return (int)(count % MOD);
    }

    public static void main(String[] args) {

    }
}
