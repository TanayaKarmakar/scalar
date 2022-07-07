package com.scalar.ds.moduloarithmetic.homework;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class ConcatenateTheNumbers {
    private static int solve(int A, int B, int C) {
        StringBuilder sb = new StringBuilder();
        int min = Integer.min(A, Integer.min(B, C));
        sb.append(min + "");
        if(min == A) {
            sb.append(Integer.min(B, C)).append(Integer.max(B, C));
        } else if(min == B) {
            sb.append(Integer.min(A, C)).append(Integer.max(A, C));
        } else {
            sb.append(Integer.min(A, B)).append(Integer.max(A, B));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {

    }
}
