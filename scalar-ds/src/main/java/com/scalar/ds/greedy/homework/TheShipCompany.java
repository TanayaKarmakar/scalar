package com.scalar.ds.greedy.homework;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class TheShipCompany {
    public int[] solve(int A, int B, int[] C) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < C.length; i++) {
            maxHeap.add(C[i]);
            minHeap.add(C[i]);
        }

        int max = 0;
        int min = 0;
        while(A > 0 && !maxHeap.isEmpty() && !minHeap.isEmpty()) {
            int el1 = maxHeap.poll();
            int el2 = minHeap.poll();

            max += el1;
            min += el2;
            el1--;
            if(el1 > 0) {
                maxHeap.add(el1);
            }
            el2--;
            if(el2 > 0) {
                minHeap.add(el2);
            }
            A--;
        }
        return new int[] {max, min};
    }

    public static void main(String[] args) {
    }
}
