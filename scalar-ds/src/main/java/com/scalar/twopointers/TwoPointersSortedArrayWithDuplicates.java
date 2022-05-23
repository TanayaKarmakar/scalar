package com.scalar.twopointers;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class TwoPointersSortedArrayWithDuplicates {
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

    private static int isSumExists(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int MOD = 1000000007;
        for(int i = 0; i < n; i++) {
            int lIndx = findLeftMost(nums, i + 1, k - nums[i]);
            if(lIndx == -1)
                continue;
            int rIndx = findRightMost(nums, i + 1, k - nums[i]);
            count += (rIndx - lIndx + 1);
        }
        return (int)(count % MOD);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 4, 5, 6, 7, 10};
        int k = 8;
        int ans = isSumExists(nums, k);

        System.out.println(ans);
    }
}
