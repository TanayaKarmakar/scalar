package com.scalar.ds.arrays.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class AddOneToTheDigits {
    private static int[] plusOne(int[] A) {
        int[] finalResult = new int[A.length + 1];

        int carry = 0;
        int sum = A[A.length - 1] + 1;

        carry = sum / 10;
        sum = sum % 10;

        finalResult[A.length] = sum;
        for(int i = A.length - 2; i >= 0; i--) {
            sum = A[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            finalResult[i + 1] = sum;
        }

        if(carry != 0) {
            finalResult[0] = carry;
        } else {
            int i = 0;
            while(i < finalResult.length && finalResult[i] == 0) {
                i++;
            }
            finalResult = Arrays.copyOfRange(finalResult, i, finalResult.length);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 6, 4, 0, 5, 5, 5 };

        int[] finalResult = plusOne(nums);

        System.out.println(Arrays.toString(finalResult));

    }
}
