package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 25/07/22
 * @project scalar
 */
public class FirstMissingNaturalNumber {
    private static int findFirstMissingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n) {
                if(i + 1 == nums[i])
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

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {-2,2,1,-3,3,7,4};

        int ans = findFirstMissingNumber(nums);

        System.out.println(ans);

        nums =new int[] {4,3,1,2,5,6};

        ans = findFirstMissingNumber(nums);

        System.out.println(ans);
    }
}
