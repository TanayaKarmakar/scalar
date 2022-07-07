package com.scalar.ds.hashing.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class LongestContinuousZeroSum {
    private static int[] lszero(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        int start = -1;
        int end = -1;

        int maxLen = Integer.MIN_VALUE;
        int currentLen = 0;

        int prefixSum = 0;
        for(int i = 0; i < A.length; i++) {
            prefixSum += A[i];
            if(prefixSum == 0) {
                currentLen = (i + 1);
                if(currentLen > maxLen) {
                    start = 0;
                    end = (i + 1);
                    maxLen = currentLen;
                }
            }
            if(map.containsKey(prefixSum)) {
                currentLen = (i - map.get(prefixSum));
                if(currentLen > maxLen) {
                    start = map.get(prefixSum) + 1;
                    end = i + 1;
                    maxLen = currentLen;
                }
            } else {
                map.put(prefixSum, i);
            }
        }

        int[] result = new int[end - start];
        int k = 0;
        for(int i = start; i < end; i++) {
            result[k++] = A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-2,4,-4};

        System.out.println(Arrays.toString(lszero(nums)));
    }
}
