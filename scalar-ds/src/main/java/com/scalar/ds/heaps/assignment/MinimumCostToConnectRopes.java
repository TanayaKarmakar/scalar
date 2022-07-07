package com.scalar.ds.heaps.assignment;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/07/22
 * @project scalar
 */
public class MinimumCostToConnectRopes {
    private static int solve(int[] A) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int el: A) {
            pQ.add(el);
        }

        int total = 0;
        while(pQ.size() > 1) {
            int el1 = pQ.poll();
            int el2 = pQ.poll();

            int res = el1 + el2;
            pQ.add(res);
            total += res;
        }

        return total;
    }

    public static void main(String[] args) {

    }
}
