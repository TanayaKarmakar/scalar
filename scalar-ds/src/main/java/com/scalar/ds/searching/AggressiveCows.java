package com.scalar.ds.searching;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class AggressiveCows {
    private static int minDistance(int[] nums, int k) {
        int n = nums.length;
        int dist = nums[n - 1] - nums[0];

        int low = 1;
        int high = dist;
        int res = 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isValidPlacement(nums, mid, k)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean isValidPlacement(int[] nums, int dist, int k) {
        int currentCoord = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - currentCoord >= dist) {
                currentCoord = nums[i];
                count++;
                if(count == k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,9};
        int k = 3;
        int ans = minDistance(nums, k);

        System.out.println(ans);
    }
}
