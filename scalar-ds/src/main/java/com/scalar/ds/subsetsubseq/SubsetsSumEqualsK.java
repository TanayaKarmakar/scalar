package com.scalar.ds.subsetsubseq;

/**
 * @author t0k02w6 on 02/03/22
 * @project scalar
 */
public class SubsetsSumEqualsK {
    private static boolean isSubsetPresent(int[] nums, int k) {
        int n = nums.length;
        int totalVal = (int)Math.pow(2, n);

        for(int i = 0; i < totalVal; i++) {
            int temp = i;
            int sum = 0;
            int l = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    sum += nums[l];
                }
                if(sum == k)
                    return true;
                temp = temp >> 1;
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, -1, 5, 2, 3, 5};
        int k = 10;

        System.out.println(isSubsetPresent(nums, k));

        k = 100;
        System.out.println(isSubsetPresent(nums, k));
    }
}
