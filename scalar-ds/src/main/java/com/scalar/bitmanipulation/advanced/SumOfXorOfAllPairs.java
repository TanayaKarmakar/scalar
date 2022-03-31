package com.scalar.bitmanipulation.advanced;

/**
 * @author t0k02w6 on 31/03/22
 * @project scalar
 */
public class SumOfXorOfAllPairs {
    private static int totalSum(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < 32; i++) {
            int setBitCount = 0;
            int resetBitCount = 0;
            for(int j = 0; j < n; j++) {
                if((nums[j] & (1 << i)) > 0)
                    setBitCount++;
                else
                    resetBitCount++;
            }
            totalSum += (setBitCount * resetBitCount) * Math.pow(2, i);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,6,8};

        int totalSum = totalSum(nums);

        System.out.println(totalSum);
    }
}
