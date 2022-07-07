package com.scalar.ds.hashing.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar
 */
public class PairWithGivenXOR {
    private static int solve(int[] A, int B) {
        //Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(set.contains(A[i] ^ B)) {
                count++;
            }
            set.add(A[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 10, 15, 7, 6};
        int B = 5;

        int count = solve(nums, B);

        System.out.println(count);

        nums = new int[]{3, 6, 8, 10, 15, 50};
        B = 5;
        count = solve(nums, B);

        System.out.println(count);
    }
}
