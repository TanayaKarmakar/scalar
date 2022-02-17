package com.scalar.hashing.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar-ds
 */
public class SubarrayWithGivenSum {
    private static int[] solve(int[] A, int B) {
        int left = 0;
        int right = 0;

        int n = A.length;
        int currentSum = 0;

        while(right < n) {
            while(right < n && currentSum < B) {
                currentSum += A[right];
                right++;
            }

            while(left <= right && currentSum >= B) {
                currentSum -= A[left];
                left++;
            }

            if(currentSum == B) {
                break;
            }
        }

        if(currentSum == B) {
            int[] result = new int[right - left];
            for(int i = left; i < right; i++) {
                result[i - left] = A[i];
            }
            return result;
        }

        return new int[] {-1};
    }

    public static void main(String[] args) {
        int[] nums = {12, 1, 50, 39, 32, 23, 22, 44, 17, 5, 9, 12, 10, 50, 26, 5, 23, 38, 31, 5, 34, 8, 21, 11, 24, 44, 18, 19, 6, 31, 3, 47, 5, 2, 33, 44, 14, 9};
        int B = 58;

        int[] ans = solve(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
