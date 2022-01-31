package com.scalar.arrays.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 23/01/22
 * @project scalar-ds
 */
public class StarPatternII {
    private static void print1(int n) {
        for(int count = 1; count <= n; count++) {
            for(int i = count; i <= n; ++i) {
                if(count == 1 || count == i || i == n)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

//    private static void print(int n) {
//        char[][] mat = new char[n][n];
//
//        for(int i = 0; i < mat.length; i++) {
//            mat[0][i] = '*';
//        }
//
//        int pos = mat[0].length - 2;
//        for(int i = 1; i < mat.length; i++) {
//            mat[i][0] = '*';
//            mat[i][pos] = '*';
//            pos--;
//        }
//
//        for(int i = 0; i < mat.length; i++) {
//            for(int j = 0; j < mat.length; j++) {
//                if(mat[i][j] == '*')
//                    System.out.print(mat[i][j]);
//                else if(j != mat[0].length - 1)
//                    System.out.print(' ');
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        print1(n);

        scanner.close();
    }
}
