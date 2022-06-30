package com.scalar.twopointers;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class PairWithGivenDifference {
    private static int countAllDiffrence(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        int count = 0;

        while(i < n && j < n) {
            int diff = nums[j] - nums[i];
            if(diff == k) {
                if(i != j)
                    count++;
                i++;
                j++;
            }
            else if(diff > k)
                i++;
            else
                j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,10,20,23,30};
        int k = 2;

        int ans = countAllDiffrence(nums, k);

        System.out.println(ans);
    }
}
