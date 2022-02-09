package com.scalar.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class IsAlpha {
    public int solve(char[] A) {
        boolean isAlpha = true;
        for(int i = 0; i < A.length; i++) {
            if(!((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z'))) {
                isAlpha = false;
                break;
            }
        }

        return isAlpha ? 1: 0;
    }
}
