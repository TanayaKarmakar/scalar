package com.scalar.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 13/02/22
 * @project scalar-ds
 */
public class PairSum {
    private static boolean isPairExists(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(k - nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15,7};
        int k = 18;

        System.out.println(isPairExists(nums, k));

        k = 14;
        System.out.println(isPairExists(nums, k));

        k = 20;
        System.out.println(isPairExists(nums, k));
    }
}
