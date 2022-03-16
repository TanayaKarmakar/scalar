package com.scalar.subsetsubseq;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class SumOfMaxOfAllSubsequences {
    private static int sumContribution(int[] nums) {
        Arrays.sort(nums);

        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += (nums[i] * (int)Math.pow(2, i));
        }

        return totalSum;
    }


    private static int sum(int[] nums) {
        int n = nums.length;
        int totalVal = (int)Math.pow(2, n);

        int totalMaxSum = 0;
        for(int i = 0; i < totalVal; i++) {
            int temp = i;
            int currentMax = Integer.MIN_VALUE;
            int j = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    currentMax = Integer.max(currentMax, nums[j]);
                }
                temp = temp >> 1;
                j++;
            }
            if(currentMax == Integer.MIN_VALUE)
                currentMax = 0;
            totalMaxSum += currentMax;
        }

        return totalMaxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,6,4};

        int sum = sum(nums);

        System.out.println("Naive technique - " + sum);

        sum = sumContribution(nums);

        System.out.println("Contribution technique - " + sum);
    }
}
