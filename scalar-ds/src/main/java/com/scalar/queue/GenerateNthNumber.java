package com.scalar.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */
public class GenerateNthNumber {
    private static int nThNumber(int[] nums, int n) {
        Deque<Integer> q = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            n--;
            if(n == 0)
                break;
        }

        if(n == 0)
            return q.peekLast();

        while(n > 0 && !q.isEmpty()) {
            int el = q.poll();
            for(int i = 0; i < nums.length; i++) {
                q.add(el * 10 + nums[i]);
                n--;
                if(n == 0)
                    break;
            }
        }

        return q.peekLast();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n = 5;

        System.out.println(nThNumber(nums, n));
    }
}
