package com.scalar.ds.searching.homework;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SearchInABitonicArray {
    private static int findPivot(int[] A) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(mid - 1 >= 0 && A[mid - 1] < A[mid] && mid + 1 < n && A[mid] > A[mid + 1])
                return mid;
            else if(mid + 1 < n && A[mid] < A[mid + 1])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static int solve(int[] A, int B) {
        int n = A.length;
        int pivotIndx = findPivot(A);
        int ans = binarySearch(A, 0, pivotIndx, B);
        if(ans != -1)
            return ans;
        ans = reverseBinarySearch(A, pivotIndx + 1, n - 1, B);
        return ans;
    }

    private static int reverseBinarySearch(int[] a, int start, int end, int b) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(a[mid] == b)
                return mid;
            else if(a[mid] > b)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static int binarySearch(int[] a, int start, int end, int b) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(a[mid] == b)
                return mid;
            else if(a[mid] > b)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int B = 12;

        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
