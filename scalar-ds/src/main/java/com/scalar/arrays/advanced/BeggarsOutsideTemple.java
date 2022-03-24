package com.scalar.arrays.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/03/22
 * @project scalar
 */
public class BeggarsOutsideTemple {
    private static int[] solve(int A, int[][] B) {
        int[] beggars = new int[A];

        for(int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int p = B[i][1];
            beggars[start - 1] += p;
        }

        for(int i = 1; i < beggars.length; i++) {
            beggars[i] += beggars[i - 1];
        }
        return beggars;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 10}, {2, 20}, {2, 25}};

        int[] finalAns = solve(A, B);

        System.out.println(Arrays.toString(finalAns));
    }
}
