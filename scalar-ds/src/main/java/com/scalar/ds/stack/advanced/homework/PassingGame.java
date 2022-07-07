package com.scalar.ds.stack.advanced.homework;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class PassingGame {
    private static int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);

        for(Integer el: C) {
            if(el == 0) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(el);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {

    }
}
