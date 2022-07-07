package com.scalar.ds.stack.advanced.homework;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class InfixToPostfix {
    private static int getPriority(String str) {
        if(str.equals("^"))
            return 3;
        else if(str.equals("*") || str.equals("/"))
            return 2;
        else if(str.equals("+") || str.equals("-"))
            return 1;
        else
            return Integer.MIN_VALUE;
    }

    private static boolean isOperator(char ch) {
        return ch == '^' || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(';
    }

    private static String solve(String A) {
        Stack<String> opStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(isOperator(ch)) {
                if(opStack.isEmpty() || getPriority(ch + "") >= getPriority(opStack.peek()) || ch == '(') {
                    opStack.push(ch + "");
                } else {
                    String opStr = opStack.pop();
                    String op2 = operandStack.pop();
                    String op1 = operandStack.pop();
                    String newStr = op1 + op2 + opStr;
                    operandStack.push(newStr);
                    opStack.push(ch + "");
                }
            } else {
                if(ch == ')') {
                    while(!opStack.isEmpty() && !opStack.peek().equals("(")) {
                        String opStr = opStack.pop();
                        String op2 = operandStack.pop();
                        String op1 = operandStack.pop();
                        String newStr = op1 + op2 + opStr;
                        //operandStack.pop();
                        operandStack.push(newStr);
                    }
                    opStack.pop();
                } else {
                    operandStack.push(ch + "");
                }
            }
        }
        if(operandStack.size() == 1)
            return operandStack.peek();
        String op2 = operandStack.pop();
        String op1 = operandStack.pop();
        return op1 + op2 + opStack.pop();
    }

    public static void main(String[] args) {
        String str = "x^y/(a*z)+b";

        String ans = solve(str);

        System.out.println(ans);
    }
}
