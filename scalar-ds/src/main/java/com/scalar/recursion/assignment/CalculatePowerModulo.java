package com.scalar.recursion.assignment;

/**
 * @author t0k02w6 on 21/02/22
 * @project scalar
 */
public class CalculatePowerModulo {
    private static long powRec(long A, long B, long C) {
        if(B == 0)
            return 1;
        long x = powRec(A, B/2, C) % C;
        if((B&1)==1)
            return ((A%C) * (((x % C) * (x % C)) % C)) % C;
        else
            return ((x % C) * (x % C)) % C;
    }

    public static int pow(int A, int B, int C) {
        if(A == 0 || C == 1) {
            return 0;
        }
        long ans = powRec(A, B, C);
        if(ans < 0) {
            ans = ans + C;
        }
        return (int)(ans);
    }

    public static void main(String[] args) {

    }
}
