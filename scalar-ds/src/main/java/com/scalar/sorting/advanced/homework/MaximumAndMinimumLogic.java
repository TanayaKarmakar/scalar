package com.scalar.sorting.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/05/22
 * @project scalar
 */
public class MaximumAndMinimumLogic {
    private static int[] solve(int[] A) {
        Arrays.sort(A);
        long max = 0;
        int start = 0;
        int end = A.length - 1;
        int MOD = 1000000007;
        while(start < end) {
            max = (max + Math.abs(A[end] - A[start]) % MOD) % MOD;
            start++;
            end--;
        }

        long min = 0;
        for(int i = 1; i < A.length; i+=2) {
            min = (min + Math.abs(A[i] - A[i - 1]) % MOD) % MOD;
        }

        return new int[]{(int)max, (int)min};
    }

    public static void main(String[] args) {
        int[] nums = {3,11,-1,5};
        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));

        nums = new int[] {2,2};
        ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
