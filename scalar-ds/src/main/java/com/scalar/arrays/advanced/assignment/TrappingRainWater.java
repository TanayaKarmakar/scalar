package com.scalar.arrays.advanced.assignment;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class TrappingRainWater {
    private static int totalWater(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int total = 0;

        while(left <= right) {
            if(A[left] < A[right]) {
                if(lMax < A[left]) {
                    lMax = A[left];
                } else {
                    total += (lMax - A[left]);
                }
                left++;
            } else {
                if(rMax < A[right]) {
                    rMax = A[right];
                } else {
                    total += (rMax - A[right]);
                }
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
