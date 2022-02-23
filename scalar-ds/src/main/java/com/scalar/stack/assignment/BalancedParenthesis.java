package com.scalar.stack.assignment;

import java.util.Stack;

/**
 * @author t0k02w6 on 23/02/22
 * @project scalar
 */
public class BalancedParenthesis {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(')
                stack.push(A.charAt(i));
            else {
                if(stack.isEmpty())
                    return 0;
                char ch = stack.peek();
                if(ch == '(')
                    stack.pop();
            }
        }

        return stack.isEmpty() ? 1: 0;
    }

    public static void main(String[] args) {

    }
}
