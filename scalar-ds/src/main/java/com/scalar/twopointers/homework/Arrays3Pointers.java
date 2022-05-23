package com.scalar.twopointers.homework;

/**
 * @author t0k02w6 on 22/05/22
 * @project scalar-ds
 */
public class Arrays3Pointers {
    private static int minimize(final int[] A, final int[] B, final int[] C) {
        int m = A.length;
        int n = B.length;
        int p = C.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int ans = Integer.MAX_VALUE;

        while(i < m && j < n && k < p) {
            int option1 = Integer.max(Math.abs(B[j] - C[k]), Math.abs(C[k] - A[i]));
            int option2 = Integer.max(Math.abs(A[i] - B[j]), option1);

            ans = Integer.min(ans, option2);
            if(A[i] <= B[j] && A[i] <= C[k])
                i++;
            else if(B[j] <= A[i] && B[j] <= C[k])
                j++;
            else
                k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,4,10};
        int[] B = {2,15,20};
        int[] C = {10, 12};

        int ans = minimize(A, B, C);

        System.out.println(ans);
    }
}
