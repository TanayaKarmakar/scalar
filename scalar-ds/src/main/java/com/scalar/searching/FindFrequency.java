package com.scalar.searching;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class FindFrequency {
    private static int findFreq(int[] nums, int k) {
        int lIndx = findLeftMost(nums, k);
        if(lIndx == -1)
            return 0;
        int rIndx = findRightMost(nums, k);
        return (rIndx - lIndx + 1);
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
        int[] nums = {-5,-5,-3,0,0,1,1,5,5,5,5,5,5,5,8,10,10,15};
        int k = 5;

        int ans = findFreq(nums, k);

        System.out.println(ans);
    }
}
