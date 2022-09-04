package com.scalar.ds.graph.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 03/09/22
 * @project scalar-ds
 */
public class ValidPath {
    private static int[][] moveDir = {{-1, 0},{1, 0},{0, 1},{0, -1},{-1,1},{1,1},{-1,-1},{1, -1}};

    private static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        Set<String> circleSet = new HashSet<>();
        int[][] directions = {{-D, 0},{D, 0},{0, D},{0, -D},{-D,D},{D,D},{-D,-D},{D, -D}};

        int col = A;
        int row = B;
        for(int i = 0; i < C; i++) {
            circleSet.add(E[i] + ":" + F[i]);
            for(int j = 0; j < directions.length; j++) {
                int newRow = F[i] + directions[j][0];
                int newCol = E[i] + directions[j][1];
                if(newRow >= 0 && newRow <= row && newCol >= 0 && newCol <= col) {
                    circleSet.add(newRow + ":" + newCol);
                }
            }
        }
        int startRow = 0;
        int startCol = 0;
        if(circleSet.contains(startRow + ":" + startCol) || circleSet.contains(row + ":" + col))
            return "NO";
        boolean[][] visited = new boolean[row + 1][col + 1];
        visited[0][0] = true;
        boolean isPossible = canReach(row, col, visited, circleSet, startRow, startCol);
        return isPossible ? "YES": "NO";
    }

    private static boolean canReach(int row, int col, boolean[][] visited, Set<String> circleSet, int startRow, int startCol) {
        if(startRow < 0 || startRow > row || startCol < 0 || startCol > col || visited[startRow][startCol] || circleSet.contains(startRow + ":" + startCol))
            return false;
        if(startRow == row && startCol == col) {
            if(circleSet.contains(startRow + ":" + startCol))
                return false;
            return true;
        }

        boolean ans = false;
        for(int j = 0; j < moveDir.length; j++) {
            int newRow = startRow + moveDir[j][0];
            int newCol = startCol + moveDir[j][1];
            if(!visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                ans |= canReach(row, col, visited, circleSet, newRow, newCol);
                visited[newRow][newCol] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 7;
        int B = 91;
        int N = 8;
        int R = 7;
        int[] E = {1, 7, 1, 7, 1, 5, 1, 6 };
        int[] F = {25, 4, 74, 14, 90, 58, 37, 4};
        System.out.println(solve(A,B,N,R,E,F));
    }
}
