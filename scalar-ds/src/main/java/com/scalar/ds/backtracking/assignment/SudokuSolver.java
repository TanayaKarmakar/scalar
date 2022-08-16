package com.scalar.ds.backtracking.assignment;

/**
 * @author t0k02w6 on 21/07/22
 * @project scalar
 */
public class SudokuSolver {
    private static void solveSudoku(char[][] A) {
        solveSudokuRec(A);
    }

    private static boolean solveSudokuRec(char[][] a) {
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] == '.') {
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }
            if(isEmpty)
                break;
        }

        //all cells are filled up
        if(!isEmpty)
            return true;

        for(int i = 1; i <= 9; i++) {
            if(isSafe(a, row, col, i)) {
                a[row][col] =(char) (i + '0');
                if(solveSudokuRec(a))
                    return true;
                a[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] a, int row, int col, int num) {
        for(int i = 0; i < a[0].length; i++) {
            if(a[row][i] - '0' == num)
                return false;
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i][col] - '0' == num)
                return false;
        }

        int sqrt = (int)Math.sqrt(a.length);
        int startRow = row - (row % sqrt);
        int startCol = col - (col % sqrt);

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(a[i][j] - '0' == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(grid);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
