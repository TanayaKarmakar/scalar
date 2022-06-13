package com.scalar.stack.advanced;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author t0k02w6 on 12/06/22
 * @project scalar
 */
public class RemoveConsecutiveDuplicates {
    private static String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> sItr = stack.iterator();
        while(sItr.hasNext()) {
            sb.append(sItr.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abaabbcd";

        String ans = removeDuplicates(str);

        System.out.println(ans);
    }
}
