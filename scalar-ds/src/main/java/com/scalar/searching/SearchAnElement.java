package com.scalar.searching;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SearchAnElement {
    private static int findElement(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k)
                return mid;
            else if(nums[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,12,14,19,20,23,25,27};
        int k = 20;

        int ans = findElement(nums, k);
        System.out.println(ans);

        k = 15;
        ans = findElement(nums, k);
        System.out.println(ans);
    }
}
