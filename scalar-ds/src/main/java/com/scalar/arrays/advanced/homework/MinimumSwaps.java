package com.scalar.arrays.advanced.homework;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class MinimumSwaps {
    private static int solve(int[] A, int B) {
        int minSwaps = 0;
        int i = -1;
        for(int j = 0; j < A.length; j++) {
            if(A[j] < B) {
                i++;
                if(i != j) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    minSwaps++;
                }
            }
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;

        int ans = solve(nums, B);

        System.out.println(ans);

        nums = new int[]{5, 17, 100, 11};
        B = 20;
        ans = solve(nums, B);

        System.out.println(ans);
    }
}
