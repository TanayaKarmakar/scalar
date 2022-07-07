package com.scalar.ds.math.advanced.gcd.assignment;

/**
 * @author t0k02w6 on 07/04/22
 * @project scalar
 */
public class Pubg {
    private static int solve(int[] A) {
        if(A.length < 2)
            return A[0];
        int gcd = gcd(A[0], A[1]);

        for(int i = 2; i < A.length; i++) {
            gcd = gcd(gcd, A[i]);
        }
        return gcd;
    }

    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
