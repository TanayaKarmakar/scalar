package com.scalar.stack.advanced.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author t0k02w6 on 15/06/22
 * @project scalar
 */
public class NearestSmallerElement {
    private static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);

        Stack<Integer> stack = new Stack<>();
        stack.push(A.get(0));

        for(int i = 1; i < A.size(); i++) {
            while(!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            if(stack.isEmpty())
                result.add(-1);
            else
                result.add(stack.peek());
            stack.push(A.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(8);

        ArrayList<Integer> result = prevSmaller(list);

        System.out.println(result);
    }
}
