package com.scalar.arrays.homework;

/**
 * @author t0k02w6 on 21/01/22
 * @project scalar-ds
 */
public class GoodSubarraysEasy {
    private static int solve(int[] A, int B) {
        int goodSubarrayCount = 0;
        for(int i = 0; i < A.length; i++) {
            long sum = 0;
            for(int j = i; j < A.length; j++) {
                int subArrayLen = (j - i + 1);
                sum += A[j];
                if((subArrayLen % 2 == 0 && sum < B)
                    || (subArrayLen % 2 != 0 && sum > B))
                    goodSubarrayCount++;
            }
        }
        return goodSubarrayCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int B = 4;

        System.out.println(solve(nums, B));

        nums = new int[] {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        B = 65;

        System.out.println(solve(nums, B));
    }
}
