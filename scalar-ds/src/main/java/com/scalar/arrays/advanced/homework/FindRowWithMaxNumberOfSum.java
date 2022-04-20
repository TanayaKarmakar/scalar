package com.scalar.arrays.advanced.homework;

/**
 * @author t0k02w6 on 24/03/22
 * @project scalar
 */
public class FindRowWithMaxNumberOfSum {
    private static int solve(int[][] A) {
        int maxOne = 0;

        int m = A.length;
        int n = A[0].length;

        int rowIndx = -1;

        for(int i = 0; i < m; i++) {
            if(A[i][n - 1] == 0)
                continue;
            else {
                int j = n - 1;
                int count = 0;
                if(A[i][0] == 1) {
                    count += n;
                } else {
                   int start = 0;
                   int end = j;
                   while(start <= end) {
                       int mid = (start + end) >> 1;
                       if(A[i][mid] == 1 && (mid != 0 && A[i][mid - 1] != 1)) {
                           count += (n - mid);
                           break;
                       } else if(A[i][mid] == 1)
                           end = mid - 1;
                       else
                           start = mid + 1;
                   }
                }
                if(maxOne < count) {
                    maxOne = count;
                    rowIndx = i;
                }
            }
        }
        return rowIndx;
    }

    public static void main(String[] args) {

    }
}
