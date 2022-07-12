package com.scalar.ds.heaps.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 11/07/22
 * @project scalar
 */
public class AthLargestElement {
    private static int[] solve(int A, int[] B) {
        int n = B.length;
        int[] res = new int[n];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i < A; i++) {
            pQ.add(B[i]);
            if(pQ.size() < A)
                res[i] = -1;
            else
                res[i] = pQ.peek();
        }

        for(int i = A; i < n; i++) {
            pQ.add(B[i]);
            if(pQ.size() > A)
                pQ.poll();

            res[i] = pQ.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int b = 4;
        int[] res = solve(b, nums);

        System.out.println(Arrays.toString(res));
    }
}
