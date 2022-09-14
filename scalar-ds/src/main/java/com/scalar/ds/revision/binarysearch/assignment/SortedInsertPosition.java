package com.scalar.ds.revision.binarysearch.assignment;

/**
 * @author t0k02w6 on 14/09/22
 * @project scalar-ds
 */
public class SortedInsertPosition {
    private static int searchInsert(int[] A, int B) {
        if(A[0] > B)
            return 0;
        int n = A.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] == B)
                return mid;
            else if(A[mid] > B)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int B = 7;
        int ans = searchInsert(nums, B);
        System.out.println(ans);
    }
}
