package com.scalar.ds.hashing.advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
public class CountOfZeroSubarraySum {
    private static int count(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == 0)
                count++;
            if(set.contains(preSum))
                count++;
            set.add(preSum);
        }

        if(preSum == 0)
            count++;

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,-3,4,3,1,-2,-3};

        int ans = count(nums);

        System.out.println(ans);

        nums = new int[] {6,-6,0,-6,6,0};
        ans = count(nums);

        System.out.println(ans);
    }
}
