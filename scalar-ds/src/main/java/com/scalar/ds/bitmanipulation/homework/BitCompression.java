package com.scalar.ds.bitmanipulation.homework;

/**
 * @author t0k02w6 on 29/01/22
 * @project scalar
 */
public class BitCompression {
    private static int compressBits(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 30, 30, 5, 24, 21, 12, 4, 16, 4, 31};
        int ans = compressBits(nums);

        System.out.println(ans);
    }
}
