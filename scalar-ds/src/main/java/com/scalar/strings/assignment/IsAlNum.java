package com.scalar.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class IsAlNum {
    private static int solve(char[] A) {
        boolean isAlpha = true;
        for(int i = 0; i < A.length; i++) {
            if(!((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z')
                || (A[i] >= '0' && A[i] <= '9'))) {
                isAlpha = false;
                break;
            }
        }

        return isAlpha ? 1: 0;
    }
}
