package com.scalar.ds.hashing.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar-ds
 */
public class SubarrayWithGivenSum {
    private static int[] solve(int[] A, int B) {
        Map<Long, Integer> map = new HashMap<>();
        long preSum = 0;

        int left = -1;
        int right = -1;

        for(int i = 0; i < A.length; i++) {
            preSum += A[i];
            if(preSum == B) {
                left = 0;
                right = i;
                break;
            }
            if(map.containsKey(preSum - B)) {
                left = map.get(preSum - B) + 1;
                right = i;
                break;
            }
            map.put(preSum, i);
        }
        if(left == -1)
            return new int[]{-1};
        int[] res = new int[right - left + 1];
        for(int i = left; i <= right; i++) {
            res[i - left] = A[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {12, 1, 50, 39, 32, 23, 22, 44, 17, 5, 9, 12, 10, 50, 26, 5, 23, 38, 31, 5, 34, 8, 21, 11, 24, 44, 18, 19, 6, 31, 3, 47, 5, 2, 33, 44, 14, 9};
        int B = 58;

        int[] ans = solve(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
