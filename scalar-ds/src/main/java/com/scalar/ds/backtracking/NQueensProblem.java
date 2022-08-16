package com.scalar.ds.backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author t0k02w6 on 20/07/22
 * @project scalar
 */
public class NQueensProblem {
    private static Set<Integer> leftDiagonals;
    private static Set<Integer> rightDiagonals;
    private static Set<Integer> columns;

    private static void nQueens(int n) {
        String[][] grid = new String[n][n];
        leftDiagonals = new HashSet<>();
        rightDiagonals = new HashSet<>();
        columns = new HashSet<>();

        solve(grid, n, 0);
    }

    private static void solve(String[][] grid, int n, int row) {
        if(row == n) {
            //printSolution
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafe(grid, n, row, i)) {
                grid[row][i] = "Q";
                columns.add(i);
                leftDiagonals.add(row - i);
                rightDiagonals.add(row + i);
                solve(grid, n, row + 1);
                grid[row][i] = "";
                columns.remove(i);
                leftDiagonals.remove(row - i);
                rightDiagonals.remove(row + i);
            }
        }
    }

    private static boolean isSafe(String[][] grid, int n, int row, int col) {
        if(columns.contains(col))
            return false;

        if(leftDiagonals.contains(row - col))
            return false;

        if(rightDiagonals.contains(row + col))
            return false;
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


    }
}
