package com.scalar.ds.sorting.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SumTheDifference {
    private static int solve(int[] A) {
        Arrays.sort(A);
        int MOD = 1000000007;
        long sum = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                sum = ((sum % MOD) + (A[j] - A[i]) % MOD) % MOD;
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,2};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
