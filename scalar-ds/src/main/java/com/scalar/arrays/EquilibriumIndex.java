package com.scalar.arrays;

/**
 * @author t0k02w6 on 08/01/22
 * @project scalar-ds
 */
public class EquilibriumIndex {
    private static int getEquilibriumIndx(int[] nums) {
        if(nums.length <= 1)
            return -1;
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int left = 0;
        int right = totalSum;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0)
                left = left + nums[i - 1];
            right = right - nums[i];
            if(left == right)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-7,1,5,2,-4,3,0};
        int indx = getEquilibriumIndx(nums);

        System.out.println(indx);
    }
}
