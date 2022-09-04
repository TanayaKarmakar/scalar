package com.scalar.ds.revision.recursion.homework;

/**
 * @author t0k02w6 on 28/08/22
 * @project scalar-ds
 */
public class KthSymbol {
    private static int solve(int A, int B) {
        return getSymbol(A - 1, B - 1);
    }

    private static int getSymbol(int A, int B) {
        if(A == 0)
            return 0;
        int parentNode = getSymbol(A - 1, B / 2);
        if(B % 2 == 0)
            return parentNode;
        else
            return 1 - parentNode;
    }

    public static void main(String[] args) {

    }
}
