package com.scalar.arrays.advanced.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class Flip {
    private static int[] flip(String A) {
        int size = A.length();
        int[] arr = new int[size];

        int oneCount = 0;
        for(int i = 0; i < size; i++) {
            if(A.charAt(i) == '0')
                arr[i] = 1;
            else {
                arr[i] = -1;
                oneCount++;
            }
        }

        if(oneCount == A.length())
            return new int[]{};

        int startIndx = -1;
        int endIndx = -1;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int globalStart = -1;
        int globalEnd = -1;

        for(int i = 0; i < size; i++) {
            currentSum += arr[i];
            if(startIndx == -1) {
                startIndx = i;
            }
            endIndx = i;
            if(currentSum > maxSum) {
                maxSum = currentSum;
                globalStart = startIndx;
                globalEnd = endIndx;
            }
            if(currentSum < 0) {
                currentSum = 0;
                startIndx = -1;
                endIndx = -1;
            }
        }
        return new int[]{globalStart + 1, globalEnd + 1};
    }

    public static void main(String[] args) {
        String str = "111";

        int[] ans = flip(str);

        System.out.println(Arrays.toString(ans));
    }
}
