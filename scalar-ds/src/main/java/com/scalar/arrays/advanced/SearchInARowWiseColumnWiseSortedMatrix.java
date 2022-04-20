package com.scalar.arrays.advanced;

/**
 * @author t0k02w6 on 28/03/22
 * @project scalar
 */
public class SearchInARowWiseColumnWiseSortedMatrix {
    private static boolean isItemFound(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while(i < m && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 10, 15, 20},{6,12,18,24},{7,14,21,28},{8,16,24,34}};
        int target = 14;

        boolean ans = isItemFound(matrix, target);

        System.out.println(ans);
    }
}
