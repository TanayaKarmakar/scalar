package com.scalar.stack.advanced.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class EvaluateExpression {
    private static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static int performResult(int num1, int num2, String str) {
        if(str.equals("+"))
            return num1 + num2;
        else if(str.equals("-"))
            return num1 - num2;
        else if(str.equals("*"))
            return num1 * num2;
        else
            return num1 / num2;
    }

    private static int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();

        for(String curr: A) {
            if(isDigit(curr)) {
                stack.push(curr);
            } else {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int result = performResult(op1,op2,curr);
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {

    }
}
