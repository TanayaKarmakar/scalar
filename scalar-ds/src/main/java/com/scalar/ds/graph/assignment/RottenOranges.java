package com.scalar.ds.graph.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 20/08/22
 * @project scalar
 */
public class RottenOranges {
    private static int[][] positions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int solve(int[][] A) {
        int time = -1;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] item = q.poll();
                int row = item[0];
                int col = item[1];

                for(int j = 0; j < positions.length;j++) {
                    int newRow = row + positions[j][0];
                    int newCol = col + positions[j][1];

                    if(newRow < 0 || newRow >= A.length || newCol < 0 || newCol >= A[0].length
                    || A[newRow][newCol] == 2 || A[newRow][newCol] == 0)
                        continue;
                    A[newRow][newCol] = 2;
                    q.add(new int[]{newRow, newCol});
                }
            }
            time++;
        }


        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1)
                    return -1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] A = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = solve(A);

        System.out.println(ans);
    }
}
