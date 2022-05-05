package com.scalar.sorting.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class SortTheUnsortedArray {
    private static int solve(int[] A) {
        int n = A.length;
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++) {
            tmp[i] = A[i];
        }

        Arrays.sort(tmp);
        int startIndx = -1;
        int endIndx = -1;
        for(int i = 0; i < n; i++) {
            if(tmp[i] != A[i]) {
                if(startIndx == -1)
                    startIndx = i;
                endIndx = i;
            }
        }
        if(startIndx == -1)
            return 0;
        return (endIndx - startIndx + 1);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 15, 25, 6, 7, 30, 40, 50};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
