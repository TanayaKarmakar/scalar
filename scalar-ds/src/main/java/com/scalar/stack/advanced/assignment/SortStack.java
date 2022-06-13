package com.scalar.stack.advanced.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class SortStack {


    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        for(Integer el: A) {
            stack.push(el);
        }
        stack = sortStack(stack);
        ArrayList<Integer> finalResult = new ArrayList<>();
        while(!stack.isEmpty()) {
            finalResult.add(stack.pop());
        }
        return finalResult;
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
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

        stack = sortStack(stack);
        stack1 = sortStack(stack1);
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

        Stack<Integer> result2 = new Stack<>();
        while(!result.isEmpty()) {
            result2.push(result.pop());
        }

        return result2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(1);

        nums = solve(nums);

        System.out.println(nums);
    }
}
