package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 23/07/22
 * @project scalar
 */
public class MaximumSubmatrixSumStartingAtRow0EndingAtLastRow {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,-4},{-5,6,-7,8},{9,10,-11,12}};
        int ans = maxSubmatrixSum(nums);

        System.out.println(ans);
    }

    private static int maxSubmatrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] prefix = new int[m][n];

        for(int i = 0; i < m; i++) {
            prefix[i][0] = nums[i][0];
        }

        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                prefix[i][j] += prefix[i][j - 1] + nums[i][j];
            }
        }

        for(int j = 0; j < n; j++) {
            for(int i = 1; i < m; i++) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }


        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxSum = Integer.max(prefix[m - 1][i], maxSum);
        }
        return maxSum;
    }
}
