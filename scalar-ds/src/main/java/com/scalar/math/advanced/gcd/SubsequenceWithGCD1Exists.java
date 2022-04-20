package com.scalar.math.advanced.gcd;

/**
 * @author t0k02w6 on 07/04/22
 * @project scalar
 */
public class SubsequenceWithGCD1Exists {
    private static boolean isSubseqExists(int[] nums) {
        if(nums.length < 2)
            return false;
        int g = gcd(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            g = gcd(g, nums[i]);
        }
        return g == 1;
    }

    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
