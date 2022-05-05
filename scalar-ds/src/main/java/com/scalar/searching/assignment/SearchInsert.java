package com.scalar.searching.assignment;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SearchInsert {
    private static int searchInsert(int[] A, int B) {
        int start = 0;
        int end = A.length - 1;
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
        int k = 5;

        System.out.println(searchInsert(nums, k));
    }
}
