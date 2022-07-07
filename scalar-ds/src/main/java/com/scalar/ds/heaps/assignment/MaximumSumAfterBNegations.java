package com.scalar.ds.heaps.assignment;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/07/22
 * @project scalar
 */
public class MaximumSumAfterBNegations {
    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i < A.length; i++) {
            pQ.add(A[i]);
        }

        while(!pQ.isEmpty() && B > 0) {
            int el = pQ.poll();
            el = -el;
            pQ.add(el);
            B--;
        }

        int sum = 0;
        while(!pQ.isEmpty()) {
            sum += pQ.poll();
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
