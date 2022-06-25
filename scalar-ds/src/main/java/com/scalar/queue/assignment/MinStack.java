package com.scalar.queue.assignment;

import java.util.Stack;

/**
 * @author t0k02w6 on 20/06/22
 * @project scalar
 */
class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            if(val == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}

public class MinStack {
    public static void main(String[] args) {

    }
}
