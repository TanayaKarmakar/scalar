package com.scalar.ds.subsetsubseq.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class SumTheDifference {
    private static int solve(int[] A) {
        Arrays.sort(A);
        int MOD = 1000000007;

        int totalSum = 0;
        int n = A.length;
        for(int i = 0; i < n; i++) {
            totalSum = (((totalSum % MOD)
                    + ((A[i] * (int)Math.pow(2, i)) % MOD)) % MOD
                    - ((A[i] * (int)Math.pow(2, n - i - 1)) % MOD)) % MOD;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,2};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
