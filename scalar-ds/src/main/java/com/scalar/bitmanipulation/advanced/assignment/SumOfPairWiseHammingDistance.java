package com.scalar.bitmanipulation.advanced.assignment;

import java.math.BigInteger;

/**
 * @author t0k02w6 on 01/04/22
 * @project scalar
 */
public class SumOfPairWiseHammingDistance {
    private static int hammingDistance(final int[] A) {
        int n = A.length;
        long result = 0;
        int MOD = 1000000007;
        for(int i = 0; i < 32; i++) {
            long countOne = 0;
            long countZero = 0;
            for(int j = 0; j < n; j++) {
                if((A[j] & (1 << i)) > 0)
                    countOne++;
                else
                    countZero++;
            }
            //result += (((((result % MOD) * (countOne % MOD)) % MOD) * (countZero % MOD)) * 2) % MOD;
            result = (result + ((((countOne % MOD) * (countZero % MOD)) % MOD) * 2) % MOD) % MOD;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6};

        int ans = hammingDistance(nums);

        System.out.println(ans);
    }
}
