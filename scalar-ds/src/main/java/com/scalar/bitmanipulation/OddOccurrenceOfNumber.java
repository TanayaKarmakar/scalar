package com.scalar.bitmanipulation;

/**
 * @author t0k02w6 on 21/12/21
 * @project scalar-ds
 */
public class OddOccurrenceOfNumber {
    private static int findOddOccurrenceNum(int[] nums) {
        if(nums.length == 0)
            return Integer.MAX_VALUE;

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,8,3,8,1,7,7};

        int result = findOddOccurrenceNum(nums);

        System.out.println(result);
    }
}
