package com.scalar.queue.homework;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class ReversingElementOfQueue {
    private static int[] solve(int[] A, int B) {
        Deque<Integer> dQ = new LinkedList<>();
        for(int i = 0; i < A.length; i++) {
            dQ.add(A[i]);
        }

        Stack<Integer> stack = new Stack<>();
        while(!dQ.isEmpty()) {
            stack.push(dQ.poll());
        }

        int n = A.length;
        int k = (n - B);

        while(k > 0 && !stack.isEmpty()) {
            dQ.addFirst(stack.pop());
            k--;
        }

        while(!stack.isEmpty()) {
            dQ.add(stack.pop());
        }

        while(B > 0) {
            dQ.addFirst(dQ.removeLast());
            B--;
        }


        int[] result = new int[n];
        int i = 0;
        while(!dQ.isEmpty()) {
            result[i++] = dQ.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};

        int B = 3;
        int[] result = solve(A, B);

        System.out.println(Arrays.toString(result));
    }
}
