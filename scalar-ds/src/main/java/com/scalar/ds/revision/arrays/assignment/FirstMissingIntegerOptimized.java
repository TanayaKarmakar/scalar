package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 25/07/22
 * @project scalar
 */
public class FirstMissingIntegerOptimized {
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0)
                nums[i] = (n + 1);
        }

        for(int i = 0; i < n; i++) {
            int k = Math.abs(nums[i]);
            if(k - 1 < n && nums[k - 1] > 0) {
                nums[k - 1] = -nums[k - 1];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return (i + 1);
        }
        return (n + 1);
    }

    public static void main(String[] args) {

    }
}
