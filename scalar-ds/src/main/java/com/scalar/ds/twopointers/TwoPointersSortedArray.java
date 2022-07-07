package com.scalar.ds.twopointers;

import java.util.Arrays;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */

//distinct array
public class TwoPointersSortedArray {
    private static int[] isSumExists(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k)
                return new int[] {start, end};
            else if(sum > k)
                end--;
            else
                start++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,10,20,23,30};
        int k = 23;

        int[] ans = isSumExists(nums, k);

        System.out.println(Arrays.toString(ans));

    }
}
