package com.scalar.searching.assignment;

/**
 * @author t0k02w6 on 04/05/22
 * @project scalar
 */
public class MatrixSearch {
    private static int searchMatrix(int[][] A, int B) {
        int m = A.length;
        int n = A[0].length;
        int start = 0;
        int end = n * (m - 1) + (n - 1);

        while(start <= end) {
            int mid = (start + end) >> 1;
            int i = mid / n;
            int j = mid % n;
            if(A[i][j] == B)
                return 1;
            else if(A[i][j] > B)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
