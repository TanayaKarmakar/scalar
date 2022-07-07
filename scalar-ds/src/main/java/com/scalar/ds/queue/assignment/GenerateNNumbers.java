package com.scalar.ds.queue.assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class GenerateNNumbers {
    private static int[] solve(int A) {
        int[] res = new int[A];
        int i = 0;
        Queue<Integer> q = new LinkedList<>();
        //int k = 0;
        for(int j = 1; j <= 3; j++) {
            q.add(j);
            res[i++] = j;
            if(i == A)
                return res;
        }

        while(!q.isEmpty() && i < A) {
            int el = q.poll();
            int base = el * 10;
            for(int j = 1; j <= 3; j++) {
                int newNumber = base + j;
                res[i++] = newNumber;
                if(i == A)
                    return res;
                q.add(newNumber);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int A = 15;
        int[] res = solve(A);

        System.out.println(Arrays.toString(res));

    }
}
