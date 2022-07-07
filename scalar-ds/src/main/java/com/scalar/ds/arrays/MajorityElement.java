package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 05/02/22
 * @project scalar-ds
 */
public class MajorityElement {
    private static int findMajority(int[] nums) {
        int mIndx = 0;
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[mIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    mIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[mIndx] == nums[i])
                count++;
        }

        if(count > nums.length / 2)
            return nums[mIndx];
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,4,4,2};

        int ans = findMajority(nums);

        System.out.println(ans);
    }
}
