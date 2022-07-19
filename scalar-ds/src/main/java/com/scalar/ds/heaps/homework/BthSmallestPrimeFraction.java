package com.scalar.ds.heaps.homework;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class BthSmallestPrimeFraction {
    static class Item implements Comparable<Item> {
        int p;
        int q;
        double fraction;

        public Item(int p, int q, double fraction) {
            this.p = p;
            this.q = q;
            this.fraction = fraction;
        }


        @Override
        public int compareTo(Item o) {
            if(this.fraction == o.fraction)
                return 0;
            else if(this.fraction < o.fraction)
                return 1;
            else
                return -1;
        }
    }

    private static int[] solve(int[] A, int B) {
        PriorityQueue<Item> pQ = new PriorityQueue<>();
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; j++) {
                pQ.add(new Item(A[i], A[j], A[i] / (double)A[j]));
            }
        }

        while(!pQ.isEmpty() && B > 0) {
            pQ.poll();
            B--;
        }
        return new int[] {pQ.peek().p, pQ.peek().q};
    }

    public static void main(String[] args) {

    }
}
