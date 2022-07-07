package com.scalar.ds.arrays.advanced.assignment;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class SpiralOrderMatrixII {
    private static int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];

        int value = 1;
        int startRow = 0;
        int endRow = A - 1;
        int startCol = 0;
        int endCol = A - 1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = value++;
            }

            startRow++;
            for(int j = startRow; j <= endRow; j++) {
                matrix[j][endCol] = value++;
            }
            endCol--;

            for(int j = endCol; j >= startCol; j--) {
                matrix[endRow][j] = value++;
            }
            endRow--;

            for(int j = endRow; j >= startRow; j--) {
                matrix[j][startCol] = value++;
            }
            startCol++;
        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}
