package com.scalar.ds.searching.homework;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class FindPeakElement {
    private static int solve(int[] A) {
        if(A.length == 1)
            return A[0];
        int n = A.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isPeak(A, mid)) {
                return A[mid];
            } else if(mid - 1 >= 0 && A[mid] < A[mid - 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static boolean isPeak(int[] a, int mid) {
        if(mid == 0)
            return a[mid] >= a[mid + 1];
        else if(mid == a.length - 1)
            return a[mid] >= a[mid - 1];
        else
            return a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
