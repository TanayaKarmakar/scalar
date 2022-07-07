package com.scalar.ds.twopointers.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class SubarrayWithGivenSum {
    private static int[] solve(int[] A, int B) {
        Map<Long, Integer> map = new HashMap<>();
        long preSum = 0;

        int start = -1;
        int end = -1;
        for(int i = 0; i < A.length; i++) {
            preSum += A[i];
            if(preSum == B) {
                start = 0;
                end = i;
                break;
            }
            if(map.containsKey(preSum - B)) {
                start = map.get(preSum - B) + 1;
                end = i;
                break;
            }

            map.put(preSum, i);
        }
        if(start == -1)
            return new int[] {-1};
        int[] res = new int[end - start + 1];
        int i = 0;
        for(int j = start; j <= end; j++) {
            res[i++] = A[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        int k = 5;

        int[] ans = solve(nums, k);

        System.out.println(Arrays.toString(ans));
    }
}
