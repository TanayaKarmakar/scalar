package com.scalar.ds.arrays.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 22/01/22
 * @project scalar-ds
 */
public class RowToColumnZero {
    private static int[][] solveOptimized(int[][] A) {
        boolean rowFlag = false;
        boolean columnFlag = false;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 0) {
                    if(i == 0)
                        rowFlag = true;
                    if(j == 0)
                        columnFlag = true;
                    A[0][j] = 0;
                    A[i][0] = 0;
                }
            }
        }

        if(rowFlag) {
            for(int i = 0; i < A[0].length; i++)
                A[0][i] = 0;
        }

        if(columnFlag) {
            for(int i = 0; i < A.length; i++) {
                A[i][0] = 0;
            }
        }

        for(int i = 1; i < A.length; i++) {
            for(int j = 1; j < A[0].length; j++) {
                if(A[i][0] == 0 || A[0][j] == 0)
                    A[i][j] = 0;
            }
        }

        return A;
    }


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
