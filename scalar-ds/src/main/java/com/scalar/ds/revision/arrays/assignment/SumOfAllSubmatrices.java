package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class SumOfAllSubmatrices {
    private static int solve(int[][] A) {
        int total = 0;
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                total += (i + 1) * (j + 1) * (m - i) * (n - j) * A[i][j];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1},{1,1}};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
