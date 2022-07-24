package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 23/07/22
 * @project scalar
 */
public class SumOfAllSubmatrices {
    private static int sum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += nums[i][j] * (i + 1) * (j + 1) * (m - i) * (n - i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};

        int ans = sum(nums);

        System.out.println(ans);
    }
}
