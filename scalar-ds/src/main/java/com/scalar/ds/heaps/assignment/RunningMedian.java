package com.scalar.ds.heaps.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 11/07/22
 * @project scalar
 */
public class RunningMedian {
    private static int[] solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(A[0]);

        List<Integer> result = new ArrayList<>();
        result.add(maxHeap.peek());

        for(int i = 1; i < A.length; i++) {
            int currentMedian = 0;
            if(maxHeap.size() > minHeap.size()) {
                if(A[i] < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(A[i]);
                } else {
                    minHeap.add(A[i]);
                }
                //currentMedian = maxHeap.peek();
            } else {
                if(A[i] > minHeap.peek()) {
                    minHeap.add(A[i]);
                    maxHeap.add(minHeap.poll());
                } else {
                    maxHeap.add(A[i]);
                }
            }
            currentMedian = maxHeap.peek();
            result.add(currentMedian);
        }

        int[] finalResult = new int[result.size()];
        int j = 0;
        for(int el: result) {
            finalResult[j++] = el;
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 4, 3};
        int[] res = solve(nums);

        System.out.println(Arrays.toString(res));
    }
}
