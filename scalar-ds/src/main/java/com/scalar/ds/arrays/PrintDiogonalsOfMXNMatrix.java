package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class PrintDiogonalsOfMXNMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5,6}, {7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24}};

        int m = mat.length;
        int n = mat[0].length;

        //upper triangle
        for(int i = n - 1; i >= 0; i--) {
            int val = i;
            for(int j = 0; (j < m && val >= 0); j++, val--) {
                System.out.print(mat[j][val] + " ");
            }
            System.out.println();
        }

        //lower triangle
        for(int i = 1; i < m; i++) {
            int val = i;
            for(int j = n - 1; (j >= 0 && val < m); j--, val++) {
                System.out.print(mat[val][j] + " ");
            }
            System.out.println();
        }

    }
}
