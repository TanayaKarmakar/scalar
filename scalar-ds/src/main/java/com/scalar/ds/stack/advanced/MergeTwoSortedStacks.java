package com.scalar.ds.stack.advanced;

import java.util.Stack;

/**
 * @author t0k02w6 on 12/06/22
 * @project scalar
 */
public class MergeTwoSortedStacks {
    private static Stack<Integer> mergeSortedStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> stack3 = new Stack<>();
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek() < stack2.peek()) {
                stack3.push(stack1.pop());
            } else {
                stack3.push(stack2.pop());
            }
        }

        while(!stack1.isEmpty()) {
            stack3.push(stack1.pop());
        }

        while(!stack2.isEmpty()) {
            stack3.push(stack2.pop());
        }

        Stack<Integer> stack4 = new Stack<>();
        while(!stack3.isEmpty()) {
            stack4.push(stack3.pop());
        }
        return stack4;
    }

    public static void main(String[] args) {

    }
}
