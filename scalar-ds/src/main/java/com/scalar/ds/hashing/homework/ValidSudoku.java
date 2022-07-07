package com.scalar.ds.hashing.homework;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar
 */
public class ValidSudoku {
    private static boolean isValid(char[][] board, int i, int j) {
        for(int col = 0; col < 9; col++) {
            if(board[i][col] == board[i][j] && j != col)
                return false;
        }

        for(int row = 0; row < 9; row++) {
            if(board[row][j] == board[i][j] && row != i)
                return false;
        }

        int sqrt = 3;
        int startRow = (i - (i % sqrt));
        int startCol = (j - (j % sqrt));
        for(int i1 = startRow; i1 < (startRow + 3); i1++) {
            for(int j1 = startCol; j1 < (startCol + 3); j1++) {
                if(board[i1][j1] == board[i][j] && !(i1 == i && j1 == j))
                    return false;
            }
        }
        return true;
    }

    private static int isValidSudoku(final String[] A) {
        char[][] board = new char[9][9];
        int i = 0;
        for(String str: A) {
            char[] arr = str.toCharArray();
            for(int j = 0; j < arr.length; j++) {
                board[i][j] = arr[j];
            }
            i++;
        }

        for(i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!isValid(board, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
