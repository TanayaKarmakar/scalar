package com.scalar.twopointers.assignment;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class CountOfPairsWithGivenSumDistinctElements {
    private static int solve(int[] A, int B) {
        int count = 0;
        int start = 0;
        int end = A.length - 1;

        while(start < end) {
            int sum = A[start] + A[end];
            if(sum == B) {
                count++;
                start++;
                end--;
            } else if(sum > B) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int B = 5;

        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
