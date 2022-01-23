package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class AntiDiagonals {
    private static int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] result = new int[2 * n - 1][n];

        int i1 = 0;
        int j1 = 0;

        for(int i = 0; i < n; i++) {
            int val = i;
            j1 = 0;
            for(int j = 0; (j < n && val >= 0); j++, val--) {
                result[i1][j1++] = A[j][val];
            }
            i1++;
        }

        for(int j = 1; j < n; j++) {
            int val = j;
            j1 = 0;
            for(int i = n - 1; (i >= 0 && val < n); i--, val++) {
                result[i1][j1++] = A[val][i];
            }
            i1++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] result = diagonal(A);

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
