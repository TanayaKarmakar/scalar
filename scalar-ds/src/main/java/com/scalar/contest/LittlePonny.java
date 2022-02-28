package com.scalar.contest;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/02/22
 * @project scalar-ds
 */
public class LittlePonny {
    private static int solve(int[] A, int B) {
        Arrays.sort(A);

        int start = 0;
        int end = A.length - 1;
        int index = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] == B && (mid == A.length - 1 || A[mid + 1] != B)) {
                index = mid;
            } else if(A[mid] > B)
                end = mid - 1;
            else
                start = mid + 1;
        }

        if(index == -1)
            return -1;
        return (A.length - index - 1);
    }

    public static void main(String[] args) {

        int[] nums = {2,4,3,1,5};

        int ans = solve(nums, 3);
        System.out.println(ans);

    }
}
