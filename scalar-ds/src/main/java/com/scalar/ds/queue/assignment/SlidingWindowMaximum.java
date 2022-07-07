package com.scalar.ds.queue.assignment;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 20/06/22
 * @project scalar
 */
public class SlidingWindowMaximum {
    private static int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
        int[] result = new int[n - B + 1];

        Deque<Integer> q = new LinkedList<>();
        int right = 0;
        for(right = 0; right < B; right++) {
            while(!q.isEmpty() && A[q.peekLast()] <= A[right]) {
                q.pollLast();
            }
            q.addLast(right);
        }

        int i = 0;
        while(right < n && !q.isEmpty()) {
            result[i++] = A[q.peek()];

            if(q.peek() < (right - B + 1)) {
                q.poll();
            }

            while(!q.isEmpty() && A[q.peekLast()] <= A[right]) {
                q.pollLast();
            }
            q.addLast(right);
            right++;
        }

        result[i] = A[q.peek()];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;

        int[] ans = slidingMaximum(nums, B);

        System.out.println(Arrays.toString(ans));


        nums = new int[]{1, 2, 3, 4, 2, 7, 1, 3, 6};
        B = 6;
        ans = slidingMaximum(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
