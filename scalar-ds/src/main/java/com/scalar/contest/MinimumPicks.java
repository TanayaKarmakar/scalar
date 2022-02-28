package com.scalar.contest;

/**
 * @author t0k02w6 on 28/02/22
 * @project scalar-ds
 */
public class MinimumPicks {
    private static int solve(int[] A) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                maxEven = Integer.max(A[i], maxEven);
            } else {
                minOdd = Integer.min(A[i], minOdd);
            }
        }

        if(maxEven == Integer.MIN_VALUE)
            maxEven = 0;
        if(minOdd == Integer.MAX_VALUE)
            minOdd = 0;
        return (maxEven - minOdd);
    }

    public static void main(String[] args) {
        int[] nums = {0,2,9};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
