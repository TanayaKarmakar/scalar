package com.scalar.ds.heaps.assignment;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/07/22
 * @project scalar
 */
public class ProductOfThree {
    private static int[] solve(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            pQ.add(A[i]);
            if((i + 1) < 3) {
                res[i] = -1;
            }
            else {
                int el1 = pQ.poll();
                int el2 = pQ.poll();
                int el3 = pQ.poll();
                res[i] = (el1 * el2 * el3);
                pQ.add(el1);
                pQ.add(el2);
                pQ.add(el3);
            }
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
