package com.scalar.ds.revision.bitmanipulation.assignment;

/**
 * @author t0k02w6 on 12/08/22
 * @project scalar
 */
public class SumOfPairwiseHammingDistance {
    private static int hammingDistance(final int[] A) {
        int n = A.length;
        long total = 0;
        int mod = 1000000007;
        for(int i = 0; i < 31; i++) {
            int setBitCount = 0;
            int resetBitCount = 0;
            for(int j = 0; j < n; j++) {
                int mask = (1 << i);
                if((A[j] & mask) > 0) {
                    setBitCount++;
                } else {
                    resetBitCount++;
                }
            }
            total = (total + ((((setBitCount % mod) * (resetBitCount % mod)) % mod) * 2) % mod) % mod;
        }
        return (int)total;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int ans = hammingDistance(nums);

        System.out.println(ans);
    }
}
