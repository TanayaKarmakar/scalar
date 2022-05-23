package com.scalar.twopointers.assignment;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class PairWithGivenDifference {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = 0;
        int count = 0;

        while(i < n && j < n) {
            int diff = A[j] - A[i];
            if(diff == B) {
                if(i != j)
                    count++;
                i++;
                j++;
            } else if(diff > B)
                i++;
            else
                j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2};
        int B = 0;
        int ans = solve(nums, B);
        System.out.println(ans);
    }
}
