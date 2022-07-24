package com.scalar.ds.revision.arrays.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/07/22
 * @project scalar
 */
public class AddOne {
    private static int[] plusOne(int[] A) {
        int n = A.length;
        int[] result = new int[n + 1];

        int sum = A[n - 1] + 1;
        int carry = (sum > 9) ? (sum / 10): 0;
        sum = sum % 10;
        result[n] = sum;
        for(int i = n - 2; i >= 0; i--) {
            sum = A[i] + carry;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            result[i + 1] = sum;
        }

        if(carry > 0)
            result[0] = carry;
        if(result[0] == 0) {
            int i = 0;
            while(i < result.length && result[i] == 0)
                i++;
            result = Arrays.copyOfRange(result, i, result.length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        int[] ans = plusOne(nums);

        System.out.println(Arrays.toString(ans));
    }
}
