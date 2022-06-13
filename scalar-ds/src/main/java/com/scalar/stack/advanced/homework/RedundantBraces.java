package com.scalar.stack.advanced.homework;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class RedundantBraces {
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(';
    }

    private static int braces(String A) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(')
                    return 1;
                stack.pop();
                stack.pop();
            } else {
                if(isOperator(ch))
                    stack.push(ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
