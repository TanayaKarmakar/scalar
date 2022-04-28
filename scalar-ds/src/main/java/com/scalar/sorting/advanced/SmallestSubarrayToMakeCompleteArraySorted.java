package com.scalar.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/04/22
 * @project scalar
 */
public class SmallestSubarrayToMakeCompleteArraySorted {
    private static int[] smallestSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int startIndx = -1;
        int endIndx = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] != temp[i]) {
                if(startIndx == -1)
                    startIndx = i;
                else
                    endIndx = i;
            }
        }
        return new int[]{startIndx, endIndx};
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5,6};
        int[] ans = smallestSubarray(nums);

        System.out.println(Arrays.toString(ans));
    }
}
