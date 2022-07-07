package com.scalar.ds.arrays.homework;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class EqualMatrix {
    private static int solve(int[][] A, int[][] B) {
        if(A.length != B.length || A[0].length != B[0].length)
            return 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != B[i][j])
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] A = {{34, 2, 82, 39},{7, 75, 54, 17},{24, 99, 69, 100},{97, 90, 21, 88},{87, 37, 33, 4}};
        int[][] B = {{34, 2, 82, 39},{7, 75, 54, 17},{24, 99, 69, 100},{97, 90, 21, 88},{87, 37, 33, 4}};

        int ans = solve(A, B);

        System.out.println(ans);
    }
}
