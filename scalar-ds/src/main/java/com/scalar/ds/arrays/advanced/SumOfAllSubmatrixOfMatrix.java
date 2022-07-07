package com.scalar.ds.arrays.advanced;

/**
 * @author t0k02w6 on 23/03/22
 * @project scalar
 */
public class SumOfAllSubmatrixOfMatrix {
    private static long finalSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        long finalSum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = (i + 1)*(j + 1)*(m - i)*(n - j);
                finalSum += count * matrix[i][j];
            }
        }
        return finalSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        long finalAns = finalSum(matrix);

        System.out.println(finalAns);
    }
}
