package com.scalar.ds.revision.arrays.homework;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class MaximumChunkToBeSorted {
    private static int solve(int[] A) {
        int n = A.length;
        int maxEl = 0;
        int i = 0;
        int chunkCount = 0;

        for(int i1 = 0; i1 < n; i1++) {
            maxEl = Integer.max(A[i], maxEl);
            if(maxEl == i)
                chunkCount++;
            i++;
        }
        return chunkCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 0};

        int ans = solve(nums);

        System.out.println(ans);

    }
}
