package com.scalar.bitmanipulation.assignment;

/**
 * @author t0k02w6 on 29/01/22
 * @project scalar
 */
public class FindingGoodDays {
    private static int solve(int A) {
        int count = 0;
        while(A != 0) {
            if((A & 1) == 1)
                count++;
            A = A >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
