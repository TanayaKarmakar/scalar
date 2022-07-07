package com.scalar.ds.stack.advanced.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author t0k02w6 on 15/06/22
 * @project scalar
 */
public class LargestRectangleInHistogram {
    private static int largestRectangleArea(ArrayList<Integer> A) {
        if(A.size() == 1)
            return A.get(0);
        int n = A.size();
        int[] nsel = new int[n];
        int[] nser = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        nsel[0] = 0;

        for(int i = 1; i < n; i++) {
            int el = A.get(i);
            while(!stack.isEmpty() && A.get(stack.peek()) >= el) {
                stack.pop();
            }
            if(stack.isEmpty())
                nsel[i] = 0;
            else
                nsel[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        stack.push((n - 1));
        nser[n - 1] = (n - 1);

        int ans = (nser[n-1] - nsel[n-1] + 1) * A. get(n-1);
        for(int i = n - 2; i >= 0; i--) {
            int el = A.get(i);
            while(!stack.isEmpty() && A.get(stack.peek()) >= el) {
                stack.pop();
            }
            if(stack.isEmpty())
                nser[i] = (n - 1);
            else
                nser[i] = stack.peek() - 1;
            stack.push(i);
            ans = Integer.max(ans, (nser[i] - nsel[i] + 1) * el);
        }
        return  ans;
    }

    public static void main(String[] args) {

    }
}
