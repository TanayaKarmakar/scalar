package com.scalar.ds.queue.homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 20/06/22
 * @project scalar
 */
public class SumOfMinAndMax {
    private static int solve(int[] A, int B) {
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        int mod = 1000000007;

        int right;
        for(right = 0; right < B; right++) {
            while(!minQ.isEmpty() && A[minQ.peekLast()] >= A[right]) {
                minQ.pollLast();
            }
            minQ.addLast(right);

            while(!maxQ.isEmpty() && A[maxQ.peekLast()] <= A[right]) {
                maxQ.pollLast();
            }
            maxQ.addLast(right);
        }

        long totalSum = 0;
        while(right < A.length && !maxQ.isEmpty() && !minQ.isEmpty()) {
            totalSum = totalSum + (A[minQ.peek()] + A[maxQ.peek()]);
            if(minQ.peek() < (right - B + 1)) {
                minQ.poll();
            }
            while(!minQ.isEmpty() && A[minQ.peekLast()] >= A[right]) {
                minQ.pollLast();
            }
            minQ.addLast(right);

            if(maxQ.peek() < (right - B + 1)) {
                maxQ.poll();
            }
            while(!maxQ.isEmpty() && A[maxQ.peekLast()] <= A[right]) {
                maxQ.pollLast();
            }
            maxQ.addLast(right);
            right++;
        }

       // totalSum = (totalSum + (A[minQ.peek()] % mod + A[maxQ.peek()] % mod) % mod) % mod;
        totalSum = totalSum + (A[minQ.peek()] + A[maxQ.peek()]);
        totalSum = totalSum % mod;
        if(totalSum < 0)
            totalSum = totalSum + mod;
        return (int)totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, -1, 7, -3, -1, -2};
        int B = 4;

        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
