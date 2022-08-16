package com.scalar.ds.backtracking.assignment;

/**
 * @author t0k02w6 on 21/07/22
 * @project scalar
 */
public class RatInAMaze {
    private static int[][] solve(int[][] A) {
        int n = A.length;
        int[][] traversedPath = new int[n][n];
        traversePath(A, 0,0,n , n , traversedPath);
        return traversedPath;
    }

    private static boolean traversePath(int[][] a, int startX, int startY, int endX, int endY, int[][] traversedPath) {
        if(startX == endX && startY == endY) {
            return true;
        }
        if(startX < 0 || startX >= endX || startY < 0 || startY >= endY || a[startX][startY] == 2 || a[startX][startY] == 0)
            return false;
        a[startX][startY] = 2;
        traversedPath[startX][startY] = 1;
        if(traversePath(a, startX - 1, startY, endX, endY, traversedPath))
            return true;
        if(traversePath(a, startX + 1, startY, endX, endY, traversedPath))
            return true;
        if(traversePath(a, startX, startY - 1, endX, endY, traversedPath))
            return true;
        if(traversePath(a, startX, startY + 1, endX, endY, traversedPath))
            return true;
        //a[startX][startY] = 1;
        traversedPath[startX][startY] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1},{1,0,1},{0,0,1}};
        int[][] ans = solve(nums);

        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
