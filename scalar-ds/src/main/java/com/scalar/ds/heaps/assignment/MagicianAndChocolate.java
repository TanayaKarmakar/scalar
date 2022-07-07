package com.scalar.ds.heaps.assignment;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/07/22
 * @project scalar
 */
public class MagicianAndChocolate {
    private static int nchoc(int A, int[] B) {
        int mod = 1000000007;

        long sum = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int el: B) {
            pQ.add(el);
        }

        while(!pQ.isEmpty() && A > 0) {
            int el = pQ.poll();
            sum += el;
            pQ.add(el / 2);
            A--;
        }

        return (int)(sum % mod);
    }

    public static void main(String[] args) {

    }
}
