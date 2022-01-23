package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class ColumnWiseSum {
    private static int[] solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[] sum = new int[n];

        for(int j = 0; j < n; j++) {
            int currentSum = 0;
            for(int i = 0; i < m; i++) {
                currentSum += A[i][j];
            }
            sum[j] = currentSum;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
