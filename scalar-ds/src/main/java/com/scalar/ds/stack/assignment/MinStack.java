package com.scalar.ds.stack.assignment;

import java.util.Stack;

/**
 * @author t0k02w6 on 23/02/22
 * @project scalar
 */
class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || (minStack.peek() > x))
            minStack.push(x);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        int item = stack.pop();
        if(minStack.peek() == item)
            minStack.pop();
    }

    public int top() {
        return stack.isEmpty() ? -1: stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1: minStack.peek();
    }
}


public class MinStack {
    public static void main(String[] args) {

    }
}
