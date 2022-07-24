package com.scalar.ds.revision.arrays.homework;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class MinimumSwaps {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int windowSize = 0;
        for(int i = 0; i < n; i++) {
            if(A[i] <= B)
                windowSize++;
        }

        int l = 0;
        int r = 0;
        int currentBadCount = 0;
        for(r = 0; r < windowSize; r++) {
            if(A[r] > B)
                currentBadCount++;
        }

        int minSwaps = Integer.MAX_VALUE;
        while(r < n) {
            minSwaps = Integer.min(minSwaps, currentBadCount);
            if(A[r] > B)
                currentBadCount++;
            r++;
            if(A[l] > B)
                currentBadCount--;
            l++;
        }
        minSwaps = Integer.min(minSwaps, currentBadCount);
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,10,3,14,10,5};
        int B = 8;
        int ans = solve(nums, B);
        System.out.println(ans);
    }
}
