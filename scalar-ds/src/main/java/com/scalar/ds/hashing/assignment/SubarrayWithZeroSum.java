package com.scalar.ds.hashing.assignment;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class SubarrayWithZeroSum {
    private static int solve(int[] A) {
        Set<Long> set = new HashSet<>();

        long prefixSum = 0;
        for(int i = 0; i < A.length; i++) {
            prefixSum += A[i];
            if(prefixSum == 0 || set.contains(prefixSum))
                return 1;
            else
                set.add(prefixSum);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
