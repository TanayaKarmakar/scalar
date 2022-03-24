package com.scalar.arrays.advanced.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
public class BeggarsOutsideTemple {
    private static int[] solve(int A, int[][] B) {
        int[] include = new int[A + 1];
        int[] exclude = new int[A + 1];
        int[] finalRes = new int[A + 1];

        for(int i = 0; i < B.length; i++) {
            int l = B[i][0];
            int r = B[i][1];
            int p = B[i][2];
            include[l] += p;
            if(r + 1 < exclude.length)
                exclude[r + 1] -= p;
        }

        for(int i = 1; i < include.length; i++) {
            include[i] += include[i - 1];
            exclude[i] += exclude[i - 1];
            finalRes[i] = include[i] + exclude[i];
        }

        return Arrays.copyOfRange(finalRes, 1, include.length);
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        int[] res = solve(A, B);

        System.out.println(Arrays.toString(res));
    }
}
