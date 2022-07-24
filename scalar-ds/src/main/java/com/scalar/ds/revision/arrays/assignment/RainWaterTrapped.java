package com.scalar.ds.revision.arrays.assignment;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class RainWaterTrapped {
    private static int trap(final int[] A) {
        int n = A.length;
        int left = 0;
        int right = n - 1;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int total = 0;
        while(left < right) {
            if(A[left] < A[right]) {
                lMax = Integer.max(lMax, A[left]);
                total += (lMax - A[left]);
                left++;
            } else {
                rMax = Integer.max(rMax, A[right]);
                total += (rMax - A[right]);
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
