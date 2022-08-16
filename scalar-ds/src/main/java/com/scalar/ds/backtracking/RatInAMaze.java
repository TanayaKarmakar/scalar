package com.scalar.ds.backtracking;

/**
 * @author t0k02w6 on 20/07/22
 * @project scalar
 */
public class RatInAMaze {
    private static boolean canReach(int[][] maze) {
        int m = maze.length;
        int n = maze.length;
        boolean[][] visited = new boolean[m][n];
        return canReachRec(maze, visited, 0, 0);
    }

    private static boolean canReachRec(int[][] maze, boolean[][] visited, int i, int j) {
        if(i == maze.length - 1 && j == maze[0].length - 1)
            return true;
        if(i >= maze.length || i < 0 || j < 0 || j >= maze[0].length || visited[i][j] || maze[i][j] == 1)
            return false;
        visited[i][j] = true;
        boolean canReach = canReachRec(maze, visited, i - 1, j);
        canReach |= canReachRec(maze, visited, i + 1, j);
        canReach |= canReachRec(maze, visited, i, j - 1);
        canReach |= canReachRec(maze, visited, i, j + 1);
        return  canReach;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,0,1,0,1,0,0},{0,1,0,1,0,1,0,0},{0,1,0,0,1,0,1,0},{0,0,1,0,0,0,0,0},
                {1,0,1,0,0,0,0,1},{0,0,0,1,0,0,0,0},{1,0,0,0,0,0,1,0},{0,0,1,0,1,0,0,0}};
        boolean ans = canReach(maze);

        System.out.println(ans);
    }
}
