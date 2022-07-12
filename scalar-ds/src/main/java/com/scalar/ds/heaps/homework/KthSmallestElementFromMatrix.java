package com.scalar.ds.heaps.homework;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/07/22
 * @project scalar
 */
public class KthSmallestElementFromMatrix {
    static class PQItem implements Comparable<PQItem>{
        int r;
        int c;
        int value;

        public PQItem(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(PQItem o) {
            if(this.value == o.value) {
                if(this.r == o.r)
                    return this.c - o.c;
                else
                    return this.r - o.r;
            }
            return o.value - this.value;
        }
    }

    private static int solve(int[][] A, int B) {
        PriorityQueue<PQItem> pQ = new PriorityQueue<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                PQItem pqItem = new PQItem(i, j, A[i][j]);
                pQ.add(pqItem);
            }
        }

        B = (A.length * A[0].length) - B;

        while(!pQ.isEmpty() && B > 0) {
            pQ.poll();
            B--;
        }
        return pQ.peek().value;
    }

    public static void main(String[] args) {

    }
}
