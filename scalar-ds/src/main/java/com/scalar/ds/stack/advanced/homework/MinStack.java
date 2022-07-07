package com.scalar.ds.stack.advanced.homework;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */

class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() > x)
            minStack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int item = stack.pop();
            if(item == minStack.peek())
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
