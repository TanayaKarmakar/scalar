package com.scalar.ds.revision.bitmanipulation;

/**
 * @author t0k02w6 on 16/08/22
 * @project scalar
 */
public class MaxAndPair {
    private static int solve(int[] nums) {
        int ans = 0;
        for(int i = 31; i >= 0; i--) {
            int count = 0;
            int mask = (1 << i);
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] != -1) {
                    if((nums[j] & mask) > 0) {
                        count++;
                    }
                }
                if(count >= 2)
                    break;
            }

            if(count >= 2) {
                for(int j = 0; j < nums.length; j++) {
                    if((nums[j] & mask) == 0) {
                        nums[j] = -1;
                    }
                }
                ans = (ans << 1);
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
