package com.scalar.recursion.advanced.homework;

/**
 * @author t0k02w6 on 16/04/22
 * @project scalar
 */
public class AnotherSequence {
    private static int solve(int A) {
        if(A == 0 || A == 1)
            return 1;
        if(A == 2)
            return 2;
        return solve(A - 1) + solve(A - 2) + solve(A - 3);
    }

    public static void main(String[] args) {

    }
}
