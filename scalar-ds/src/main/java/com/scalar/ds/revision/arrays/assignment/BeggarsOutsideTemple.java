package com.scalar.ds.revision.arrays.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class BeggarsOutsideTemple {
    private static int[] solve(int A, int[][] B) {
        int[] beggars = new int[A];
        for(int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            int amount = B[i][2];
            beggars[start - 1] += amount;
            if(end < A)
                beggars[end] -= amount;
        }

        for(int i = 1; i < beggars.length; i++) {
            beggars[i] += beggars[i - 1];
        }
        return beggars;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1,2,10},{2,3,20},{2,5,25}};

        int[] ans = solve(A, B);

        System.out.println(Arrays.toString(ans));
    }
}
