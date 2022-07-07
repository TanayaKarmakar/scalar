package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 23/01/22
 * @project scalar-ds
 */
public class PrintStartEndIndexOfSubarrayOfSizeK {
    private static void solve(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(j - i + 1 == k) {
                    System.out.println("Start - " + i + ": End - " + j);
                    break;
                }
            }
        }
    }

    private static void solveOptimized1(int[] nums, int k) {
        int start = 0;
        int n = nums.length;

        while(start + k - 1 < n) {
            System.out.println("Start - " + start + ": End - " + (start + k - 1));
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,-1,6,7,8,9,3,2,-1,4};
        int k = 3;
        System.out.println("Naive");
        solve(nums, k);

        System.out.println("Optimized");
        solveOptimized1(nums, k);
    }
}
