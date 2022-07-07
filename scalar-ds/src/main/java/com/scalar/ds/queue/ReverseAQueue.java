package com.scalar.ds.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */
public class ReverseAQueue {
    private static Queue<Integer> reverse(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()) {
            stack.push(q.poll());
        }

        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(3);
        q.add(5);
        q.add(9);
        q.add(1);
        q.add(8);
        q.add(7);

        q = reverse(q);

        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
