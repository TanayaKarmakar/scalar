package com.scalar.ds.twopointers.assignment;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class PairsWithGivenSumII {
    private static int findLeftMost(int[] nums, int start, int k) {
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid == start || nums[mid - 1] != k))
                return mid;
            else if(nums[mid] >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    private static int findRightMost(int[] nums, int start, int k) {
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid == nums.length - 1 || nums[mid + 1] != k))
                return mid;
            else if(nums[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int solve(int[] A, int B) {
        int n = A.length;
        long count = 0;
        int MOD = 1000000007;
        for(int i = 0; i < n; i++) {
            int lIndx = findLeftMost(A, i + 1, B - A[i]);
            if(lIndx == -1)
                continue;
            int rIndx = findRightMost(A, i + 1, B - A[i]);
            count += (rIndx - lIndx + 1);
        }
        return (int)(count % MOD);
    }

    public static void main(String[] args) {

    }
}
