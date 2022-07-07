package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class PrintDigonalsOfSquareMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int n = mat.length;
        //top left
        System.out.println("Top left");

        for(int i = 0; i < n; i++) {
            System.out.print(mat[i][i] + " ");
        }
        System.out.println();

        //top right
        System.out.println("Top Right");

        for(int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            System.out.print(mat[i][j] + " ");
        }
    }
}
