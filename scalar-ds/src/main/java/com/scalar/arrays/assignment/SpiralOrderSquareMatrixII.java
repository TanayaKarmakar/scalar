package com.scalar.arrays.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class SpiralOrderSquareMatrixII {
    private static int[][] generateMatrix(int A) {
        int[] spiral1D = new int[A * A];

        int[][] spiral2D = new int[A][A];

        int val = 1;
        for(int i = 0; i < A; i++) {
            for(int j = 0; j < A; j++) {
                spiral2D[i][j] = val++;
            }
        }

        int n = 2 * A - 1;
        int startRow = 0;
        int endRow = A - 1;
        int startCol = 0;
        int endCol = A - 1;
        int k = 0;

        for(int i = 0; i < n; i++) {
            int currentCol = startCol;
            while(currentCol <= endCol) {
                spiral1D[k++] = spiral2D[startRow][currentCol];
                currentCol++;
            }

            startRow++;
            int currentRow = startRow;
            while(currentRow <= endRow) {
                spiral1D[k++] = spiral2D[currentRow][endCol];
                currentRow++;
            }

            endCol--;
            currentCol = endCol;
            while (currentCol >= startCol) {
                spiral1D[k++] = spiral2D[endRow][currentCol];
                currentCol--;
            }

            endRow--;
            currentRow = endRow;
            while(currentRow >= startRow) {
                spiral1D[k++] = spiral2D[currentRow][startCol];
                currentRow--;
            }
            startCol++;
        }

        k = 0;
        for(int i = 0; i < A; i++) {
            for(int j = 0; j < A; j++) {
                spiral2D[i][j] = spiral1D[k++];
            }
        }

        return spiral2D;
    }

    private static void print(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int A = 80;
        int[][] res = generateMatrix(A);

        print(res);
    }
}
