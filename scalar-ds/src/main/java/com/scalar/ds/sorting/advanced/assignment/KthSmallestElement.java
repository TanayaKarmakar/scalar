package com.scalar.ds.sorting.advanced.assignment;

/**
 * @author t0k02w6 on 28/04/22
 * @project scalar
 */
public class KthSmallestElement {
    private static int kthsmallest(final int[] A, int B) {
        int n = A.length;
        int last = n - 1;
        for(int i = 0; i < (n - 1); i++) {
            int max = 0;
            for(int j = 0; j <= last; j++) {
                if(A[max] < A[j]) {
                    max = j;
                }
            }
            if(last != max) {
                int tmp = A[max];
                A[max] = A[last];
                A[last] = tmp;
            }
            last--;
        }

        //System.out.println(Arrays.toString(A));
        return A[B - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,2};
        int k = 3;

        int ans = kthsmallest(nums, k);
        System.out.println(ans);
    }
}
