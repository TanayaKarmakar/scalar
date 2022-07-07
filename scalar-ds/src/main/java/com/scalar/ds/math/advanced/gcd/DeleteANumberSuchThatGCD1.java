package com.scalar.ds.math.advanced.gcd;

/**
 * @author t0k02w6 on 07/04/22
 * @project scalar
 */
public class DeleteANumberSuchThatGCD1 {
    private static boolean isDeletePossible(int[] nums) {
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
        int[] nums = {6, 10,15,25,24,18};

        boolean ans = isDeletePossible(nums);

        System.out.println(ans);

        nums = new int[] {5,15,30};

        ans = isDeletePossible(nums);

        System.out.println(ans);
    }
}
