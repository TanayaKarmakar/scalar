package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class SumOfSubarrayBetweenTwoIndices {
    private static int sumOfSubarrayBetweenIndices(int[] nums, int l, int r) {
        int n = nums.length;
        int[] prefix = new int[n];

        int currentSum = 0;
        for(int i = 0; i < n; i++) {
            currentSum += nums[i];
            prefix[i] = currentSum;
        }

        if(l == 0)
            return prefix[r];
        else
            return prefix[r] - prefix[l - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,-4,5,7,11,13,-59};
        int l = 2;
        int r = 5;
        int ans = sumOfSubarrayBetweenIndices(nums, l, r);

        System.out.println(ans);
    }
}
