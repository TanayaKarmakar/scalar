package com.scalar.recursion.advanced.assignment;

/**
 * @author t0k02w6 on 16/04/22
 * @project scalar
 */
public class PowerFunction {
    private static long powerRec(long A, long B, long C) {
        if(B == 0) {
            if(A == 0)
                return 0;
            else
                return 1;
        }
        long smallValue = powerRec(A, B / 2, C);
        if(B % 2 == 0)
            return ((smallValue % C) * (smallValue % C)) % C;
        else
            return (((A * (smallValue % C)) % C) * (smallValue % C)) % C;

    }

    private static int pow(int A, int B, int C) {
        if(A < 0) {
            A = A + C;
        }
        return (int)powerRec(A, B, C);
    }

    public static void main(String[] args) {

    }
}
