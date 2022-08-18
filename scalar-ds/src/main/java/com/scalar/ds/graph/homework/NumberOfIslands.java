package com.scalar.ds.graph.homework;

/**
 * @author t0k02w6 on 18/08/22
 * @project scalar
 */
public class NumberOfIslands {
    private static final int[][] pos = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};

    private static int solve(int[][] A) {
        int count = 0;
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && A[i][j] == 1) {
                    count++;
                    dfs(A, visited, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] a, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        for(int k = 0; k < pos.length; k++) {
            int newRow = i + pos[k][0];
            int newCol = j + pos[k][1];
            dfs(a, visited, newRow, newCol, m, n);
        }
    }

    public static void main(String[] args) {

    }
}
