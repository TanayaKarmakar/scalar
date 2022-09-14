package com.scalar.ds.graph.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/09/22
 * @project scalar-ds
 */
public class ShortestDistanceInAMaze {
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int solve(int[][] A, int[] B, int[] C) {
        int startRow = B[0];
        int startCol = B[1];

        int endRow = C[0];
        int endCol = C[1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startRow, startCol});

        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[startRow][startCol] = true;

        int min = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int j = 0; j  < directions.length; j++) {
                    int newRow = curr[0] + directions[j][0];
                    int newCol = curr[1] + directions[j][1];
                    if(newRow == endRow && newCol == endCol) {
                        if(A[endRow][endCol] == 1)
                            return min;
                        else
                            return -1;
                    }
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol] || A[newRow][newCol] == 1)
                        continue;
                    q.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
            min++;
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
