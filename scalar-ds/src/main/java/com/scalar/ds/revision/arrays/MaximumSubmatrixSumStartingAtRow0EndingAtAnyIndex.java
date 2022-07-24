package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 23/07/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartingAtRow0EndingAtAnyIndex {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,-4},{-5,6,-7,8},{9,10,-11,-12}};
        int ans = maxSubmatrixSum(nums);

        System.out.println(ans);
    }

    private static int maxSubmatrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[] sum = new int[n];


        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            sum[0] += nums[i][0];
            for (int j = 1; j < n; j++) {
                sum[j] += nums[i][j] + sum[j - 1];
            }

            int currentSum = 0;
            for(int j = 0; j < n; j++) {
                currentSum += sum[j];
                maxSum = Integer.max(maxSum, currentSum);
                if(currentSum < 0)
                    currentSum = 0;
            }
        }
        return maxSum;
    }


}
