package com.scalar.ds.revision.binarysearch;

/**
 * @author t0k02w6 on 14/09/22
 * @project scalar-ds
 */
public class FindFrequencyOfANumber {
    private static int findLeftMostIndx(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
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

    private static int findRightMostIndx(int[] nums, int k, int start) {
        int n = nums.length;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid == n - 1 || nums[mid + 1] != k))
                return mid;
            else if(nums[mid] <= k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }


    private static int freq(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1) {
            if(nums[0] == k)
                return 1;
            else
                return 0;
        }
        int lIndx = findLeftMostIndx(nums, k);
        if(lIndx == -1)
            return 0;
        int rIndx = findRightMostIndx(nums, k, lIndx);
        return (rIndx - lIndx + 1);
    }

    public static void main(String[] args) {
        int[] nums = {-5,-5,-3,0,0,1,1,5,5,5,5,5,5,5,8,10,10,15};
        int k = 5;
        int ans = freq(nums, k);

        System.out.println(ans);
    }
}
