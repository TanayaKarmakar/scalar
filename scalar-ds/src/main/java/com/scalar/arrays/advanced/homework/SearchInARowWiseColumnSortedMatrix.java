package com.scalar.arrays.advanced.homework;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class SearchInARowWiseColumnSortedMatrix {
    private static int solve(int[][] A, int B) {
        int m = A.length;
        int n = A[0].length;

        int row = 0;
        int column = n - 1;
        int min = Integer.MAX_VALUE;
        while(row < m && column >= 0) {
            if(A[row][column] == B
                    && ((column > 0 && A[row][column - 1]!= B) || (row > 0 && A[row - 1][column] != B))) {
               return (1009 * (row + 1)) + column + 1;

            } else if(A[row][column] >= B) {
                int option1 = Integer.MAX_VALUE;
                int option2 = Integer.MAX_VALUE;
                if(row > 0 && A[row - 1][column] == B) {
                    option1 = 1009 * row + (column + 1);
                }
                if(column > 0 && A[row][column - 1] == B) {
                    option2 = 1009 * (row + 1) + column;
                }
                if(option1 == Integer.MAX_VALUE && option2 != Integer.MAX_VALUE)
                    column--;
                else {
                    if(option1 < option2) {
                        min = option1;
                        row--;
                    } else {
                        min = option2;
                        column--;
                    }
                }
            }
            else
                row++;
        }
        return min == Integer.MAX_VALUE ? -1: min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,2,6},{7,8,9}};
        int B = 2;

        int ans = solve(matrix, B);

        System.out.println(ans);
    }
}
