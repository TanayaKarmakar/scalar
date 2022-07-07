package com.scalar.ds.hashing.advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
public class SubarrayOfSumZero {
    private static boolean isSumZero(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int preSum = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == 0)
                return true;
            if(set.contains(preSum))
                return true;
            set.add(preSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,-3,4,3,1,-2,-3};

        boolean ans = isSumZero(nums);

        System.out.println(ans);
    }
}
