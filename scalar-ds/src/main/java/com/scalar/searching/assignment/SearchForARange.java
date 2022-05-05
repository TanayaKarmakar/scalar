package com.scalar.searching.assignment;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SearchForARange {
    private static int[] searchRange(final int[] A, int B) {
        int lIndx = findLeftMost(A, B);
        if(lIndx == -1)
            return new int[]{-1,-1};
        int rIndx = findRightMost(A, B);
        return new int[] {lIndx, rIndx};
    }

    private static int findRightMost(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid + 1 == nums.length || nums[mid + 1] != k ))
                return mid;
            else if(nums[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int findLeftMost(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid == 0 || nums[mid - 1] != k))
                return mid;
            else if(nums[mid] >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
