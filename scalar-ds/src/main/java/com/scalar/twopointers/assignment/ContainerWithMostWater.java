package com.scalar.twopointers.assignment;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class ContainerWithMostWater {
    private static int maxArea(int[] A) {
        int n = A.length;
        int l = 0;
        int r = n - 1;

        int total = 0;
        while(l < r) {
            if(A[l] < A[r]) {
                total = Integer.max(total, A[l] * (r - l));
                l++;
            } else{
                total = Integer.max(total, A[r] * (r - l));
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,3};
        int ans = maxArea(nums);

        System.out.println(ans);
    }
}
