package com.scalar.ds.revision.arrays.homework;

/**
 * @author t0k02w6 on 24/07/22
 * @project scalar
 */
public class RowWithMaximumNumberOfOnes {
    private static int findLeftMostOne(int[] nums, int n) {
        int start = 0;
        int end = n - 1;

        while(start < end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == 1 && (mid == 0 || nums[mid - 1] != 1))
                return mid;
            else if(nums[mid] >= 1)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end;
    }

    private static int solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int maxOne = 0;
        int minRowIndx = -1;

        for(int i = 0; i < m; i++) {
            if(A[i][n - 1] == 1) {
                int leftMostIndx = findLeftMostOne(A[i], n);
                if(leftMostIndx != -1) {
                    int countOfOne = (n - leftMostIndx);
                    if(maxOne < countOfOne) {
                        maxOne = countOfOne;
                        minRowIndx = i;
                    }
                }
            }
        }

        return minRowIndx;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1}};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
