package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 23/07/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartingAtRow0EndingAtLastRowKadane {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,-4},{-5,6,-7,8},{9,10,-11,12}};
        int ans = maxSubmatrixSum(nums);

        System.out.println(ans);
    }

    private static int maxSubmatrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int[] sum = new int[n];

        for(int j = 0; j < n; j++) {
            int currentSum = nums[0][j];
            for(int i = 1; i < m; i++) {
                currentSum += nums[i][j];
            }
            sum[j] = currentSum;
        }

        int globalMaxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < n; i++) {
            currentSum += sum[i];
            globalMaxSum = Integer.max(globalMaxSum, currentSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return globalMaxSum;
    }
}
