package com.scalar.ds.stack.advanced.assignment;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class DoubleCharacterTrouble {
    private static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(stack.isEmpty() || ch != stack.peek())
                stack.push(ch);
            else
                stack.pop();
        }

        if(stack.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        Iterator<Character> sItr = stack.iterator();

        while(sItr.hasNext()) {
            sb.append(sItr.next());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String str = "cddfeffe";

        String ans = solve(str);

        System.out.println(ans);
    }
}
