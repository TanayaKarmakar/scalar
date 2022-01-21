package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 20/01/22
 * @project scalar-ds
 */
public class MaximumSubarrayEasy {
    private static int maxSubarray(int A, int B, int[] C) {
        int maxPossibleSum = Integer.MIN_VALUE;
        for(int i = 0; i < C.length; i++) {
            int currentSum = 0;
            for(int j = i; j < C.length; j++) {
                currentSum += C[j];
                if(currentSum > B)
                    break;
                maxPossibleSum = Integer.max(maxPossibleSum, currentSum);
            }
        }
        return maxPossibleSum == Integer.MIN_VALUE ? 0: maxPossibleSum;
    }

    public static void main(String[] args) {
        int[] C = {2, 1, 3, 4, 5};
        int A = 5;
        int B = 12;

        int ans = maxSubarray(A, B, C);
        System.out.println(ans);
    }
}
