package com.scalar.ds.backtracking;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class CountSubsetWithSumK {
    private static int count = 0;

    private static int countSubsetsWithSumK(int[] nums, int k) {
        count = 0;
        //List<Integer> current = new ArrayList<>();

        countSubsetsWithSumKRec(nums, 0, k, 0);
        return count;
    }

    private static void countSubsetsWithSumKRec(int[] nums, int i, int k, int target) {
        if(i == nums.length) {
            if(target == k)
                count++;
            return;
        }
        countSubsetsWithSumKRec(nums, i + 1, k, target);
        countSubsetsWithSumKRec(nums, i + 1, k, target + nums[i]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 1;

        int ans = countSubsetsWithSumK(nums, k);

        System.out.println(ans);
    }
}
