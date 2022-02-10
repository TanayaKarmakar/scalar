package com.scalar.sorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author t0k02w6 on 06/02/22
 * @project scalar-ds
 */
public class RemoveElementInAnOptimalWay {
    private static int findOptimalCost(int[] nums) {
        Arrays.sort(nums);

        int currentCost = 0;
        for(int i = 0; i < nums.length; i++) {
            currentCost += nums[i];
        }

        int totalCost = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            totalCost += currentCost;
            currentCost -= nums[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2};

        int ans = findOptimalCost(nums);

        System.out.println(ans);
    }
}
