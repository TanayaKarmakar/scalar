package com.scalar.ds.bitmanipulation.advanced;

/**
 * @author t0k02w6 on 01/04/22
 * @project scalar
 */
public class MaximumANDValueOfAnyPair {
    private static int maxAND(int[] nums) {
        int n = nums.length;

        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] != -1) {
                    if((nums[j] & (1 << i)) > 0) {
                        count++;
                    }
                    if(count >= 2)
                        break;
                }
            }

            if(count >= 2) {
                for(int j = 0; j < n; j++) {
                    if(nums[j] != -1) {
                        if((nums[j] & (1 << i)) == 0) {
                            nums[j] = -1;
                        }
                    }
                }
                result = result | (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {26,13,23,28,7,25};

        int ans = maxAND(nums);

        System.out.println(ans);
    }
}
