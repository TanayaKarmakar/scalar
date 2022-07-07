package com.scalar.ds.searching;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class FloorOfAGivenNumber {
    private static int floor(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        int finalAns = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k)
                return nums[mid];
            else if(nums[mid] > k)
                end = mid - 1;
            else {
                //finalAns = Integer.max(finalAns,nums[mid])
                finalAns = nums[start];
                start = mid + 1;
            }
        }
        return finalAns;
    }

    public static void main(String[] args) {
        int[] nums = {-5,2,3,6,9,10,11,14,18};
        int k = 5;
        int ans = floor(nums, k);

        System.out.println(ans);
    }
}
