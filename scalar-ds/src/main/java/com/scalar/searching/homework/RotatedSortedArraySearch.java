package com.scalar.searching.homework;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class RotatedSortedArraySearch {
    private static int findPivot(int[] A) {
        int n = A.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(mid + 1 < n && A[mid] > A[mid + 1])
                return mid;
            else if(mid - 1 >= 0 && A[mid - 1] >= A[mid])
                return (mid - 1);
            else if(A[start] <= A[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static int search(final int[] A, int B) {
        int pivotIndx = findPivot(A);
        if(pivotIndx == -1)
            return binarySearch(A, 0, A.length - 1, B);
        else if(B >= A[0] && B < A[pivotIndx])
            return binarySearch(A, 0, pivotIndx, B);
        else
            return binarySearch(A, pivotIndx + 1, A.length - 1, B);
    }

    private static int binarySearch(int[] a, int start, int end, int key) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(a[mid] == key)
                return mid;
            else if(a[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
