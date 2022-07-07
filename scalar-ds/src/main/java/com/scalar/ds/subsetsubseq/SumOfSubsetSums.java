package com.scalar.ds.subsetsubseq;

/**
 * @author t0k02w6 on 02/03/22
 * @project scalar
 */
public class SumOfSubsetSums {
    private static int totalSumContribution(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        return totalSum * (int)Math.pow(2, n - 1);
    }

    private static int totalSum(int[] nums) {
        int n = nums.length;
        int totalVal = (int)Math.pow(2, n);

        int totalSum = 0;
        for(int i = 0; i < totalVal; i++) {
            int temp = i;
            int currentSum = 0;
            int j = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    currentSum += nums[j];
                }
                temp = temp >> 1;
                j++;
            }
            totalSum += currentSum;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,6,4};

        int ans = totalSum(nums);

        System.out.println(ans);

        ans = totalSumContribution(nums);

        System.out.println(ans);
    }
}
