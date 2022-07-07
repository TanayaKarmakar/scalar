package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class PrintRowWiseSum {
    public static void main(String[] args) {
        int[][] mat = {{3,8,9,2},{1,2,3,6},{4,10,11,13}};

        for(int i = 0; i < mat.length; i++){
            long rowSum = 0;
            for(int j = 0; j < mat[0].length; j++) {
                rowSum += mat[i][j];
            }
            System.out.println(rowSum);
        }
    }
}
