package com.scalar.searching.homework;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class SingleElementInASortedArray {
    private static int value = 0;

    private static int solve(int[] A) {
        value = 0;
        solveRec(A, 0, A.length - 1);
        return value;
    }

    private static void solveRec(int[] a, int start, int end) {
        if(start > end)
            return;
        int mid = (start + end) >> 1;
        int lIndx = findLeftMost(a, a[mid], start, end);
        int rIndx = findRightMost(a, a[mid], start, end);
        if(rIndx == lIndx) {
            value = a[lIndx];
            return;
        }
        solveRec(a, start, lIndx - 1);
        solveRec(a, rIndx + 1, end);
    }

    private static int findRightMost(int[] nums, int k, int start, int end) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid + 1 == nums.length || nums[mid + 1] != k ))
                return mid;
            else if(nums[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int findLeftMost(int[] nums, int k, int start, int end) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == k && (mid == 0 || nums[mid - 1] != k))
                return mid;
            else if(nums[mid] >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,7};
        int res = solve(nums);

        System.out.println(res);

        nums = new int[] {2,3,3};
        res = solve(nums);

        System.out.println(res);

    }
}
