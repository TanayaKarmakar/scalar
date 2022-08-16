package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class MaximumSubmatrixStartsAtAnyRowEndsAtAnyRow {
    private static int maximumSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int maxSum = Integer.MIN_VALUE;
        for(int r1 = 0; r1 < m; r1++) {
            int[] sum = new int[n];
            for(int r2 = 0; r2 < m; r2++) {
                for(int c = 0; c < n; c++) {
                    sum[c] += nums[r2][c];
                }

                int currentSum = 0;
                for(int i = 0; i < n; i++) {
                    currentSum += sum[i];
                    maxSum = Integer.max(currentSum, maxSum);
                    if(currentSum < 0)
                        currentSum = 0;
                }
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[][] nums = {{1,2,3,-4},{-5,6,-7,8},{9,10,-11,-12}};

        int ans = maximumSum(nums);

        System.out.println(ans);
    }
}
