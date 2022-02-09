package com.scalar.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class ToUpper {
    private static char[] toUpper(char[] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 'a' && A[i] <= 'z') {
                A[i] = (char)(A[i] - 32);
            }
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
