package com.scalar.moduloarithmetic.homework;

/**
 * @author t0k02w6 on 03/02/22
 * @project scalar-ds
 */
public class LeapYear {
    private static int solve(int A) {
        return ((A % 4 == 0 && A % 100 != 0) || A % 400 == 0)? 1: 0;
    }

    public static void main(String[] args) {

    }
}
