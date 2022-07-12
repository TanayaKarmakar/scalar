package com.scalar.ds.heaps.homework;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 12/07/22
 * @project scalar
 */
public class MinimumLargestElement {
    static class PQItem implements Comparable<PQItem>{
        int el;
        int indx;

        public PQItem(int el, int indx) {
            this.el = el;
            this.indx = indx;
        }

        @Override
        public int compareTo(PQItem o) {
            return this.el - o.el;
        }
    }

    private static int solve(int[] A, int B) {
        PriorityQueue<PQItem> pQ = new PriorityQueue<>();
        int n = A.length;
        int[] state = new int[n];

        for(int i = 0; i < n; i++) {
            PQItem pqItem = new PQItem(2 * A[i], i);
            pQ.add(pqItem);
            state[i] = A[i];
        }

        while(!pQ.isEmpty() && B > 0) {
            PQItem pqItem = pQ.poll();
            int indx = pqItem.indx;
            state[indx] = pqItem.el;
            pQ.add(new PQItem(pqItem.el + A[indx], indx));
            B--;
        }

        int maxEl = Integer.MIN_VALUE;
        for(int i = 0; i < state.length; i++) {
            maxEl = Integer.max(maxEl, state[i]);
        }
        return maxEl;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,4,2};
        int B = 5;

        int ans = solve(nums, B);
        System.out.println(ans);
    }
}
