package com.scalar.ds.graph.homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 21/08/22
 * @project scalar
 */
public class DistanceToNearestOne {
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int[][] solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    int[] pos = {i, j, 0};
                    q.add(pos);
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] current = q.poll();

            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for(int j = 0; j < directions.length; j++) {
                int newRow = x + directions[j][0];
                int newCol = y + directions[j][1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol])
                    continue;
                int newDist = dist + 1;
                result[newRow][newCol] = newDist;
                visited[newRow][newCol] = true;
                q.add(new int[]{newRow, newCol, newDist});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,1},{0,0,1,1},{0,1,1,0}};
        int[][] ans = solve(grid);

        for(int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
