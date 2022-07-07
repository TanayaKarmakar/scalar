package com.scalar.ds.queue.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class TaskScheduler {
    private static int solve(int[] A, int[] B) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < A.length; i++) {
            q.add(A[i]);
        }

        int i = 0;
        int total = 0;
        while(!q.isEmpty() && i < B.length) {
            int el = q.poll();
            total++;
            if(el == B[i]) {
                i++;
                continue;
            }
            q.add(el);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};

        int ans = solve(A, B);

        System.out.println(ans);
    }
}
