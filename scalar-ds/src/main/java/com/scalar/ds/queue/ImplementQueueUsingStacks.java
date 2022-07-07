package com.scalar.ds.queue;

import java.util.Stack;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */

class MyStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(int item) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(item);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int poll() {
        if(stack1.isEmpty())
            return -1;
        return stack1.pop();
    }

    public int top() {
        if(stack1.isEmpty())
            return -1;
        return stack1.peek();
    }
}

public class ImplementQueueUsingStacks {
}
