package com.scalar.ds.searching;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class NTasksKWorkers {
    private static int minTime(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            max = Integer.max(max, nums[i]);
            total += nums[i];
        }

        int low = max;
        int high = total;
        int res = 0;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isValidDistribution(nums,k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isValidDistribution(int[] nums, int k, int mid) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
        int k = 3;
        int ans = minTime(nums, k);

        System.out.println(ans);
    }
}
