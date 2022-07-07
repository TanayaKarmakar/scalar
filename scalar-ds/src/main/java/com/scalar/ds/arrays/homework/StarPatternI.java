package com.scalar.ds.arrays.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 23/01/22
 * @project scalar-ds
 */
public class StarPatternI {
    private static void print(int n) {
        char[][] mat = new char[2*n][2*n];

        //upper half
        int col = n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = '*';
            }

            for(int j = 2*n - 1; j > (2*n - 1 - col); j--) {
                mat[i][j] = '*';
            }
            col--;
        }

        //lower half
        col = 1;
        for(int i = n; i < mat.length; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = '*';
            }

            for(int j = 2*n - 1; j > (2*n - 1 - col); j--) {
                mat[i][j] = '*';
            }
            col++;
        }


        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(mat[i][j] == '*')
                    System.out.print(mat[i][j]);
                else
                    System.out.print(' ');
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        print(n);

        scanner.close();
    }
}
