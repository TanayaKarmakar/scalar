package com.scalar.hashing.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar-ds
 */
public class TwoSum {
    private static int[] twoSum(final int[] A, int B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(B - A[i])) {
                return new int[] {map.get(B - A[i]).get(0), i + 1};
            }
            if(!map.containsKey(A[i])) {
                map.put(A[i], new ArrayList<>());
            }
            map.get(A[i]).add(i + 1);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int B = -3;

        int[] ans = twoSum(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
