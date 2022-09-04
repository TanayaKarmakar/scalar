package com.scalar.ds.revision.recursion.assignment;

/**
 * @author t0k02w6 on 26/08/22
 * @project scalar-ds
 */
public class ImplementPowerFunction {
    public int pow(int A, int B, int C) {
        if(A < 0)
            A = (A + C);
        return (int)powRec(A, B, C);
    }

    private static long powRec(int A, int B, int C) {
        if(A <= 1)
            return A;
        if(B == 0)
            return 1;
        long x = powRec(A, B / 2, C);
        if(B % 2 == 0)
            return ((x % C) * (x % C)) % C;
        else
            return (((A * (x % C)) % C) * (x % C)) % C;
    }

    public static void main(String[] args) {

    }
}
