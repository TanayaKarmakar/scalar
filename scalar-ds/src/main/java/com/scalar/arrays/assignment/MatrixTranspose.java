package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class MatrixTranspose {
    private static int[][] transpose(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[col][row];

        for(int j = 0; j < col; j++) {
            for(int i = 0; i < row; i++) {
                result[j][i] = mat[i][j];
            }
        }
        return result;
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
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int[][] result = transpose(mat);

        print(result);
    }
}
