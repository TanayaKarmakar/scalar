package com.scalar.ds.backtracking;

/**
 * @author t0k02w6 on 20/07/22
 * @project scalar
 */
public class RatInAMazeModified {
    private static int pathCount = 0;
    private static int currentCheeseCount = 0;

    private static int numPaths(int[][] maze, int si, int sj, int di, int dj) {
        int m = maze.length;
        int n = maze[0].length;
        int cheeseCount = 0;
        pathCount = 0;
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2)
                    cheeseCount++;
            }
        }

        boolean[][] visited = new boolean[m][n];
        pathCount(maze, visited, si,sj,di,dj,m,n,cheeseCount);
        return pathCount;
     }

    private static void pathCount(int[][] maze, boolean[][] visited, int startI, int startJ, int endI, int endJ,
                                  int m, int n, int cheeseCount) {
        if(startI == endI && startJ == endJ) {
            if(currentCheeseCount == cheeseCount) {
                pathCount++;
            }
            return;
        }
        if(startI < 0 || startI >= m || startJ < 0 || startJ >= n || visited[startI][startJ] || maze[startI][startJ] == 1)
            return;
        visited[startI][startJ] = true;
        if(maze[startI][startJ] == 2)
            currentCheeseCount++;
        pathCount(maze, visited, startI - 1, startJ, endI, endJ, m, n, cheeseCount);
        pathCount(maze, visited, startI + 1, startJ, endI, endJ, m, n, cheeseCount);
        pathCount(maze, visited, startI, startJ - 1, endI, endJ, m, n, cheeseCount);
        pathCount(maze, visited, startI, startJ + 1, endI, endJ, m, n, cheeseCount);
        visited[startI][startJ] = false;
        if(maze[startI][startJ] == 2)
            currentCheeseCount--;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,2,2,2},{2,2,1,2},{0,2,2,2}};
        int startI = 0;
        int startJ = 0;
        int endI = 2;
        int endJ = 0;

        int count = numPaths(maze, startI, startJ, endI, endJ);

        System.out.println(count);
    }
}
