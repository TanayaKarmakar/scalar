package com.scalar.stack.homework;

import java.util.Stack;

/**
 * @author t0k02w6 on 23/02/22
 * @project scalar
 */
public class BalancedParenthesis2 {
    private static boolean isValid(char currentChar, char topChar) {
        return (currentChar == ')' && topChar == '(')
                || (currentChar == '}' && topChar == '{')
                || (currentChar == ']' && topChar == '[');
    }

    private static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(' || A.charAt(i) == '{' || A.charAt(i) == '[') {
                stack.push(A.charAt(i));
            } else {
                if(stack.isEmpty())
                    return 0;
                char topChar = stack.peek();
                if(!isValid(A.charAt(i), topChar))
                    return 0;
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1: 0;
    }

    public static void main(String[] args) {

    }
}
