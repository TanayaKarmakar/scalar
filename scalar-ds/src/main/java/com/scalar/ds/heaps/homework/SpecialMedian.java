package com.scalar.ds.heaps.homework;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class SpecialMedian {
    private static long[] constructMedianArrayFromLeft(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long[] result = new long[n];
        maxHeap.add(A[0]);
        result[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            if(maxHeap.size() > minHeap.size()) {
                if(A[i] < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(A[i]);
                } else {
                    minHeap.add(A[i]);
                }
                result[i] = ((long)(maxHeap.peek() + minHeap.peek())) / 2;
            } else {
                if(A[i] < minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(A[i]);
                } else {
                    maxHeap.add(A[i]);
                }
                result[i] = maxHeap.peek();
            }
        }
        return result;
    }

    private static long[] constructMedianArrayFromRight(int[] A) {
        int n = A.length;
        long[] result = new long[n];
        result[n - 1] = A[n - 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(A[n - 1]);
        for(int i = n - 2; i >= 0; i--) {
            if(maxHeap.size() > minHeap.size()) {
                if(A[i] < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(A[i]);
                } else {
                    minHeap.add(A[i]);
                }
                result[i] = ((long)(maxHeap.peek() + (long)minHeap.peek())) / 2;
            } else {
                if(A[i] < minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(A[i]);
                } else {
                    maxHeap.add(A[i]);
                }
                result[i] = maxHeap.peek();
            }
        }
        return result;
    }

    private static int solve(int[] A) {
        if(A.length <= 1)
            return 0;
        long[] left = constructMedianArrayFromLeft(A);
        long[] right = constructMedianArrayFromRight(A);

        int n = A.length;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(i == 0) {
                if(right[i + 1] == A[i] && A[i] != 0)
                    count++;
            } else if(i == n - 1) {
                if(left[i - 1] == A[i] && A[i] != 0)
                    count++;
            } else {
                if((left[i - 1] == A[i] || right[i + 1] == A[i]) && A[i] != 0)
                    count++;
            }
        }
        return count > 0 ? 1: 0;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 6, 8, 4};
//        int count = solve(nums);
//
//        System.out.println(count);
//
//        nums = new int[] {2, 7, 3, 1};
//        count = solve(nums);
//
//        System.out.println(count);

        int[] nums = new int[] { 2147483647, -2147483648, 0 };
        int count = solve(nums);

        System.out.println(count);
    }
}
