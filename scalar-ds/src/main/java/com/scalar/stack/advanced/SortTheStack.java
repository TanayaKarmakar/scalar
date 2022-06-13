package com.scalar.stack.advanced;

import java.util.Stack;

/**
 * @author t0k02w6 on 12/06/22
 * @project scalar
 */
public class SortTheStack {
    private static Stack<Integer> sortTheStackOptimized(Stack<Integer> stack) {
        if(stack.isEmpty() || stack.size() == 1)
            return stack;
        int size = stack.size();
        int half = size / 2;
        Stack<Integer> stack1 = new Stack<>();
        int count = 0;
        while(!stack.isEmpty() && count < half) {
            stack1.push(stack.pop());
            count++;
        }
        stack = sortTheStackOptimized(stack);
        stack1 = sortTheStackOptimized(stack1);
        return merge(stack, stack1);
    }

    private static Stack<Integer> merge(Stack<Integer> stack, Stack<Integer> stack1) {
        if(stack.isEmpty())
            return stack1;
        if(stack1.isEmpty())
            return stack;
        Stack<Integer> result = new Stack<>();
        while(!stack.isEmpty() && !stack1.isEmpty()) {
            if(stack.peek() < stack1.peek()) {
                result.push(stack.pop());
            } else {
                result.push(stack1.pop());
            }
        }

        while(!stack.isEmpty()) {
            result.push(stack.pop());
        }

        while(!stack1.isEmpty()) {
            result.push(stack1.pop());
        }

        Stack<Integer> result1 = new Stack<>();
        while(!result.isEmpty()) {
            result1.add(result.pop());
        }

        return result1;
    }


    private static Stack<Integer> sortTheStack(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(!stack.isEmpty()) {
            int item = stack.pop();
            if(stack1.isEmpty() || stack1.peek() < item) {
                stack1.push(item);
            } else {
                while(!stack1.isEmpty() && stack1.peek() > item) {
                    stack2.push(stack1.pop());
                }
                stack1.push(item);

                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }
        return stack1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(10);
        stack.push(12);
        stack.push(6);
        stack.push(5);

        Stack<Integer> resultStack = sortTheStackOptimized(stack);
        System.out.println(resultStack);
    }
}
