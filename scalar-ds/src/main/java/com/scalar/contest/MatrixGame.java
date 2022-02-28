package com.scalar.contest;

import java.util.Scanner;

/**
 * @author t0k02w6 on 28/02/22
 * @project scalar-ds
 */
public class MatrixGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arr = input.split("\\s+");

        int row = Integer.parseInt(arr[0]);
        int col = Integer.parseInt(arr[1]);
        int queries = Integer.parseInt(arr[2]);

        int[][] mat = new int[row][col];
        int val = 1;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = val++;
            }
        }

        int count = 0;
        while(count < queries) {
            String currentQuery = scanner.nextLine();
            arr = currentQuery.split("\\s+");
            int queryType = Integer.parseInt(arr[0]);
            if(queryType == 1) {
                int c1 = Integer.parseInt(arr[1]) - 1;
                int c2 = Integer.parseInt(arr[2]) - 1;

                for(int i = 0; i < row; i++) {
                    int tmp = mat[i][c1];
                    mat[i][c1] = mat[i][c2];
                    mat[i][c2] = tmp;
                }
            } else if(queryType == 2) {
                int r1 = Integer.parseInt(arr[1]) - 1;
                int r2 = Integer.parseInt(arr[2]) - 1;

                int[] tmp = mat[r1];
                mat[r1] = mat[r2];
                mat[r2] = tmp;
            } else if(queryType == 3) {
                int x1 = Integer.parseInt(arr[1]) - 1;
                int y1 = Integer.parseInt(arr[2]) - 1;
                int x2 = Integer.parseInt(arr[3]) - 1;
                int y2 = Integer.parseInt(arr[4]) - 1;
                System.out.println((mat[x1][y1] | mat[x2][y2]));
            } else {
                int x1 = Integer.parseInt(arr[1]) - 1;
                int y1 = Integer.parseInt(arr[2]) - 1;
                int x2 = Integer.parseInt(arr[3]) - 1;
                int y2 = Integer.parseInt(arr[4]) - 1;
                System.out.println((mat[x1][y1] & mat[x2][y2]));
            }
            count++;
        }
        scanner.close();
    }
}
