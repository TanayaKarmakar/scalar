package com.scalar.arrays.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class RowToColumnZero {
    private static int[][] solve(int[][] A) {
        List<Integer> zeroRowIndx = new ArrayList<>();
        List<Integer> zeroColumnIndx = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 0) {
                    zeroColumnIndx.add(j);
                    zeroRowIndx.add(i);
                }
            }
        }

        for(Integer row: zeroRowIndx) {
            for(int i = 0; i < A[0].length; i++) {
                A[row][i] = 0;
            }
        }

        for(Integer col: zeroColumnIndx) {
            for(int i = 0; i < A.length; i++) {
                A[i][col] = 0;
            }
        }

        return A;
    }

    public static void main(String[] args) {

    }
}
