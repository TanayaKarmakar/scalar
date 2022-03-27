package com.scalar.arrays.advanced.assignment;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class MinimumSwaps2 {
    private static int solve(int[] A) {
        int swapCount = 0;

        for(int i = 0; i < A.length; i++) {
            while(A[i] != i) {
                int k = A[i];
                int tmp = A[k];
                A[k] = A[i];
                A[i] = tmp;
                swapCount++;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,3};

        int ans = solve(nums);

        System.out.println(ans);

        nums = new int[] {1,2,3,4,0};

        ans = solve(nums);

        System.out.println(ans);

    }
}
