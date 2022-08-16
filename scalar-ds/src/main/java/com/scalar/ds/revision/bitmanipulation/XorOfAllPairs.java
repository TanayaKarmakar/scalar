package com.scalar.ds.revision.bitmanipulation;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class XorOfAllPairs {
    private static int solve(int[] nums) {
        int total = 0;
        int n = nums.length;

        for(int i = 0; i < 32; i++) {
            int mask = (1 << i);
            int setBitCount = 0;
            for(int j = 0; j < n; j++) {
                if((nums[j] & mask) > 0) {
                    setBitCount++;
                }
            }
            total += setBitCount * (n - setBitCount) * (int) Math.pow(2, i);
        }
        return total * 2;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
