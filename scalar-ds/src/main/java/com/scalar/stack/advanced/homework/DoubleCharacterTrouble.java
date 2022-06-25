package com.scalar.stack.advanced.homework;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */
public class DoubleCharacterTrouble {
    private static String solve(String A) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch)
                stack.push(ch);
            else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> sItr = stack.iterator();

        while(sItr.hasNext()) {
            sb.append(sItr.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abbc";

        String ans = solve(str);

        System.out.println(ans);

    }
}
