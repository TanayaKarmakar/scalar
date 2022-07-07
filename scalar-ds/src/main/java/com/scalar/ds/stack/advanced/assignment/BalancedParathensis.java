package com.scalar.ds.stack.advanced.assignment;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class BalancedParathensis {
    private static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty() || !isValid(ch, stack.peek()))
                    return 0;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? 1: 0;
    }

    private static boolean isValid(char ch, char topChar) {
        return (ch == ')' && topChar == '(')
                || (ch == '}' && topChar == '{')
                || (ch == ']' && topChar == '[');
    }

    public static void main(String[] args) {

    }
}
