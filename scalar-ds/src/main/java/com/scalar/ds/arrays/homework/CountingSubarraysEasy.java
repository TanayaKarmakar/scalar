package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 21/01/22
 * @project scalar-ds
 */
public class CountingSubarraysEasy {
    private static int solve(int[] A, int B) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            long sum = 0;
            for(int j = i; j < A.length; j++) {
                sum += A[j];
                if(sum < B)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6};
        int B = 10;
        int count = solve(nums, B);

        System.out.println(count);


    }
}
