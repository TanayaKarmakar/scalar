package com.scalar.ds.searching;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class MaximumSubarraySizeWithSumLessThanGivenSum {
    private static int findMaxK(int[] nums, int s) {
        int n =  nums.length;
        int low = 1;
        int high = n;
        int res = 0;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isValidDistribution(nums, mid, s)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean isValidDistribution(int[] nums, int limit, int s) {
        int left = 0;
        int right = 0;
        int sum = 0;
        for(right = 0; right < limit; right++) {
            sum += nums[right];
        }

        while(right < nums.length) {
            if(sum > s)
                return false;
            sum += nums[right];
            right++;
            sum -= nums[left];
            left++;
        }
        if(sum > s)
            return false;
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {1,20,3,7};
        int s = 25;

        int ans = findMaxK(nums, s);

        System.out.println(ans);
    }
}
