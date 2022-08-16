package com.scalar.ds.revision.bitmanipulation.homework;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class InterestingArray {
    private static String solve(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        return (sum % 2 == 0) ? "Yes": "No";
    }

    public static void main(String[] args) {
        int[] nums = {9, 17};

        String ans = solve(nums);

        System.out.println(ans);
    }
}
