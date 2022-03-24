package com.scalar.arrays.advanced.assignment;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class SumOfAllSubMatrices {
    private static int solve(int[][] A) {
        int n = A.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                totalSum += (i + 1) * (j + 1) * (n - i) * (n - j)*A[i][j];
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {

    }
}
