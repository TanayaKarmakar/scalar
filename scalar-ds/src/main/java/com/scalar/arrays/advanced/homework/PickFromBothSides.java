package com.scalar.arrays.advanced.homework;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class PickFromBothSides {
    private static int solve(int[] A, int B) {
        int left = 0;
        int right = 0;
        int i = 0;
        for(i = 0; i < B; i++) {
            left += A[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int k = 0;
        int n = A.length;
        i = i - 1;
        for(int j = 0; j < B; j++) {
            maxSum = Integer.max(maxSum, left + right);
            left = left - A[i];
            i--;
            right += A[n - 1 - k];
            k++;
        }
        maxSum = Integer.max(maxSum, left + right);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, -2, 3 , 1, 2};
        int B = 3;

        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
