package com.scalar.searching.homework;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class CeilingOfAnArray {
    private static int solve(int A, int[] B, int C) {
        int start = 0;
        int end = A - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(B[mid] == C)
                return B[mid];
            else if(B[mid] > C) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start >= A ? -1:B[start];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 9, 18};
        int k = 7;

        System.out.println(solve(nums.length, nums, k));

        nums = new int[] {3, 7, 9, 11, 19, 20};
        k = 22;

        System.out.println(solve(nums.length, nums, k));
    }
}
