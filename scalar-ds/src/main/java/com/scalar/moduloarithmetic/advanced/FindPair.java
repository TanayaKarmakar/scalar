package com.scalar.moduloarithmetic.advanced;

/**
 * @author t0k02w6 on 03/04/22
 * @project scalar
 */

//given array of N elements such that (A[i] + A[j]) % M = 0, for all i != j and (i, j) = (j, i)
public class FindPair {
    private static int findCount(int[] nums, int M) {
        int n = nums.length;
        int[] frequency = new int[M];
        for(int i = 0; i < nums.length; i++) {
            int r = nums[i] % M;
            frequency[r]++;
        }

        int totalCount = 0;
        int i = 1;
        int j = M - 1;
        while(i < j) {
            totalCount += frequency[i] * frequency[j];
            i++;
            j--;
        }
        totalCount += (frequency[0] * (frequency[0] - 1))/2;
        if(M % 2 == 0) {
            int mHalf = (M / 2);
            totalCount += (frequency[mHalf] * (frequency[mHalf] - 1))/2;
        }
        return totalCount;
    }

    public static void main(String[] args) {

    }
}
