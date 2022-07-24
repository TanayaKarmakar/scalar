package com.scalar.ds.revision.arrays.homework;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class SearchInARowWiseColumnWiseSortedMatrix {
    private static int solve(int[][] A, int B) {
        int m = A.length;
        int n = A[0].length;
        int ans = Integer.MAX_VALUE;

        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0) {
            if(A[i][j] >= B) {
                if(A[i][j] == B) {
                    ans = Integer.min(ans, 1009 * (i + 1) + j + 1);
                }
                j--;
            } else {
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1: ans;

    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int B = 2;
        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
