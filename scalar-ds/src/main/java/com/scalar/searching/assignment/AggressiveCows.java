package com.scalar.searching.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class AggressiveCows {
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;

        int low = 1;
        int high = A[n - 1] - A[0];

        int res = 0;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isValidPlacement(A, B, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean isValidPlacement(int[] a, int b, int dist) {
        int lastPlaced = a[0];
        int count = 1;
        for(int i = 1; i < a.length; i++) {
            if(a[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = a[i];
                if(count == b)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        int ans = solve(nums, k);

        System.out.println(ans);
    }
}
