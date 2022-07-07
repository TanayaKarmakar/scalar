package com.scalar.ds.bitmanipulation.advanced.homework;

/**
 * @author t0k02w6 on 28/03/22
 * @project scalar
 */
public class InterestingArray {
    private static String solve(int[] A) {
        int n = A.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            res ^= A[i];
        }

        return (res % 2 == 0) ? "Yes": "No";
    }

    public static void main(String[] args) {

    }
}
