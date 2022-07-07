package com.scalar.ds.stack.advanced.homework;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */
public class NextGreaterElement {
    private static int[] nextGreater(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        result[n - 1] = -1;
        stack.push(A[n - 1]);

        for(int i = n - 2; i >= 0; i--) {
            int el = A[i];
            while(!stack.isEmpty() && stack.peek() <= el) {
                stack.pop();
            }
            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            stack.push(el);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10};

        int[] result = nextGreater(nums);

        System.out.println(Arrays.toString(result));
    }
}
