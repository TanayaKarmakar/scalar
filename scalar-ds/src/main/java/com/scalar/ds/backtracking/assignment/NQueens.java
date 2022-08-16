package com.scalar.ds.backtracking.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 21/07/22
 * @project scalar
 */
public class NQueens {
    private static List<String[]> solutions;
    private static Set<Integer> columns;
    private static Set<Integer> leftDiagonals;
    private static Set<Integer> rightDiagonals;


    private static String[][] solveNQueens(int A) {
        solutions = new ArrayList<>();
        columns = new HashSet<>();
        leftDiagonals = new HashSet<>();
        rightDiagonals = new HashSet<>();
        String[][] grid = new String[A][A];
        for(int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], "");
        }

        solve(grid, A, 0);
        String[][] finalSolution = new String[solutions.size()][];
        for(int i = 0; i < solutions.size(); i++) {
            finalSolution[i] = solutions.get(i);
        }
        return finalSolution;
    }

    private static void generateSolutions(String[][] grid, List<String[]> solutions) {
        String[] strs = new String[grid.length];
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j].equals(""))
                    sb.append(".");
                else
                    sb.append(grid[i][j]);
            }
            strs[i] = sb.toString();
        }
        solutions.add(strs);
    }

    private static void solve(String[][] grid, int a, int row) {
        if(row == a) {
            generateSolutions(grid, solutions);
            return;
        }

        for(int i = 0; i < a; i++) {
            if(isSafe(grid, row, i)) {
                grid[row][i] = "Q";
                columns.add(i);
                leftDiagonals.add(row - i);
                rightDiagonals.add(row + i);
                solve(grid, a, row + 1);
                grid[row][i] = "";
                columns.remove(i);
                leftDiagonals.remove(row - i);
                rightDiagonals.remove(row + i);
            }
        }
    }

    private static boolean isSafe(String[][] grid, int row, int col) {
       if(columns.contains(col))
           return false;
       if(leftDiagonals.contains(row - col))
           return false;
       if(rightDiagonals.contains(row + col))
           return false;
       return true;
    }

    public static void main(String[] args) {
        int n = 4;
        String[][] grid = solveNQueens(n);

        for(String[] strs: grid) {
            System.out.println(Arrays.toString(strs));
        }
    }
}
