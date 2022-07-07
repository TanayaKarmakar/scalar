package com.scalar.ds.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class MaximumValueOfSlidingWindowOfSizeK {
    private static int[] solve(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> q = new LinkedList<>();

        int right = 0;
        for(right = 0; right < k; right++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[right]) {
                q.pollLast();
            }
            q.addLast(right);
        }
        int i = 0;

        while(!q.isEmpty() && right < n) {
            result[i] = nums[q.peek()];
            i++;
            if(q.peek() < (right - k + 1)) {
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[right]) {
                q.pollLast();
            }
            q.addLast(right);
            right++;
        }
        result[i] = nums[q.peek()];

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,8,9,7,6,5,11,3};

        int k = 3;
        int[] result = solve(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
