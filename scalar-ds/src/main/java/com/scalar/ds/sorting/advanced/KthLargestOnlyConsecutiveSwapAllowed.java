package com.scalar.ds.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/04/22
 * @project scalar
 */
public class KthLargestOnlyConsecutiveSwapAllowed {
    private static int kthLargest(int[] nums, int k) {
        int n = nums.length;
        int tmpK = k;
        for(int i = 0; i < n; i++) {
            if(tmpK > 0) {
                for(int j = 1; j < (n - i); j++) {
                    if(nums[j] < nums[j - 1]) {
                        int tmp = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = tmp;
                    }
                }
                tmpK--;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[n - k];
    }

    public static void main(String[] args) {
        int[] nums = {5,8,1,3,15,7,2};
        int k = 2;
        int ans = kthLargest(nums, k);

        System.out.println(ans);
    }
}
