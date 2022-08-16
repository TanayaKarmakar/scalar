package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 25/07/22
 * @project scalar
 */
public class FirstMissingInteger {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n) {
                if(nums[i] == (i + 1))
                    break;
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1))
                return (i + 1);
        }
        return (n + 1);
    }

    public static void main(String[] args) {

    }
}
