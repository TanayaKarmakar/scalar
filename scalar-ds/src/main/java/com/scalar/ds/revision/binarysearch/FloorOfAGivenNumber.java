package com.scalar.ds.revision.binarysearch;

/**
 * @author t0k02w6 on 14/09/22
 * @project scalar-ds
 */
public class FloorOfAGivenNumber {
    private static int floor(int[] nums, int k) {
        if(k < nums[0])
            return Integer.MIN_VALUE;
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int finalAns = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k)
                return mid;
            else if(nums[mid] > k)
                end = mid - 1;
            else {
                finalAns = nums[start];
                start = mid + 1;
            }

        }
        return finalAns;
    }

    public static void main(String[] args) {
        int[] nums = {-5,2,3,4,10,11,13,16,20};
        int k = 6;
        int ans = floor(nums, k);

        System.out.println(ans);
    }
}
