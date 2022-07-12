package com.scalar.ds.heaps.assignment;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 11/07/22
 * @project scalar
 */
public class KPlacesApart {
    private static int[] solve(int[] A, int B) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i <= B; i++) {
            pQ.add(A[i]);
        }

        int[] res = new int[A.length];
        int j = 0;
        for(int i = B + 1; i < A.length; i++) {
            res[j++] = pQ.poll();
            pQ.add(A[i]);
        }

        while(!pQ.isEmpty()) {
            res[j++] = pQ.poll();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
