package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 25/07/22
 * @project scalar
 */
public class MaximumSubmatrixSumOfSizeB {
    private static int solve(int[][] A, int B) {
        int m = A.length;
        int n = A[0].length;
        int maxSum = Integer.MIN_VALUE;


        for(int r1 = 0; r1 <= (m - B); r1++) {
            int[] sum = new int[n];
            for(int r2 = r1; r2 < (r1 + B); r2++) {
                for(int c = 0; c < n; c++) {
                    sum[c] += A[r2][c];
                }
            }

            int l = 0;
            int r = 0;
            int currentSum = 0;
            for(r = 0; r < B; r++) {
                currentSum += sum[r];
            }

            while(r < n) {
                maxSum = Integer.max(currentSum, maxSum);
                currentSum += sum[r];
                r++;
                currentSum -= sum[l];
                l++;
            }
            maxSum = Integer.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1,1,1},{2,2,2,2,2},{3, 8, 6, 7, 3},{4, 4, 4, 4, 4},{5, 5, 5, 5, 5}};
        int B = 3;

        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
