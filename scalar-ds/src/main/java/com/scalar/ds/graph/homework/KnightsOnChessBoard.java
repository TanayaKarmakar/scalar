package com.scalar.ds.graph.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 01/09/22
 * @project scalar-ds
 */
public class KnightsOnChessBoard {
    private static final int[][] directions = {{1,2},{-1,2},{2,1},{-2,1},{2,-1},{-2,-1},{1,-2},{-1,-2}};

    private static int knight(int A, int B, int C, int D, int E, int F) {
        int row = A + 1;
        int col = B + 1;

        int startR = C;
        int startC = D;
        int endR = E;
        int endC = F;

        int count = 0;
        boolean[][] visited = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i1 = 0; i1 < size; i1++) {
                int[] curr = q.poll();
                if(curr[0] == endR && curr[1] == endC)
                    return count;
                for(int i = 0; i < directions.length; i++) {
                    int newR = curr[0] + directions[i][0];
                    int newC = curr[1] + directions[i][1];

                    if(newR <= 0 || newR >= row || newC <= 0 || newC >= col || visited[newR][newC])
                        continue;
                    q.add(new int[] {newR, newC});
                    visited[newR][newC] = true;
                }
            }
            count++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int A = 8;
        int B = 8;
        int C = 1;
        int D = 1;
        int E = 8;
        int F = 8;

        int ans = knight(A, B, C, D, E, F);
        System.out.println(ans);
    }
}
