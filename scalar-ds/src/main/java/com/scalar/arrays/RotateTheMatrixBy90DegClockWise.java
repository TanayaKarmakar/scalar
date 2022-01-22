package com.scalar.arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class RotateTheMatrixBy90DegClockWise {
    private static void rotate(int[][] mat) {
        int n = mat.length;

        int start = 0;
        int end = n - 1;
        while(start < end) {
            int[] tmp = mat[start];
            mat[start] = mat[end];
            mat[end] = tmp;
            start++;
            end--;
        }


        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
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

        rotate(mat);

        print(mat);
    }
}
