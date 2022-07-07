package com.scalar.ds.twopointers.homework;

/**
 * @author t0k02w6 on 22/05/22
 * @project scalar-ds
 */
public class MinimizeAbsoluteDifference {
    private static int solve(int[] A, int[] B, int[] C) {
        int m = A.length;
        int n = B.length;
        int p = C.length;
        int i = 0;
        int j = 0;
        int k = 0;

        int ans = Integer.MAX_VALUE;
        while(i < m && j < n && k < p) {
            int max = Integer.max(A[i], Integer.max(B[j], C[k]));
            int min = Integer.min(A[i], Integer.min(B[j], C[k]));
            int diff = Math.abs(max - min);
            ans = Integer.min(ans, diff);
            if(min == A[i])
                i++;
            else if(min == B[j])
                j++;
            else
                k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,4,5,8,10};
        int[] B = {6,9,15};
        int[] C = {2,3,6,6};

        int ans = solve(A, B, C);
        System.out.println(ans);
    }
}
