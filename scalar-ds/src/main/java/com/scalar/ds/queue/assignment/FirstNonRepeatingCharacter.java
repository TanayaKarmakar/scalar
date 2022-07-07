package com.scalar.ds.queue.assignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 20/06/22
 * @project scalar
 */
public class FirstNonRepeatingCharacter {
    private static String solve(String A) {
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(q.isEmpty()) {
                if(map.containsKey(ch)) {
                    sb.append("#");
                } else {
                    q.add(ch);
                    map.put(ch, 1);
                    sb.append(q.peek());
                }
            } else {
                if(map.containsKey(ch)) {
                    int val = map.get(ch);
                    map.put(ch, val + 1);
                    q.remove(ch);
                } else {
                    map.put(ch, 1);
                    q.add(ch);
                }
                if(q.isEmpty()) {
                    sb.append("#");
                } else {
                    sb.append(q.peek());
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String aStr = "iergxwhddh";

        String result = solve(aStr);

        System.out.println(result);

//        aStr = "abcabc";
//
//        result = solve(aStr);
//
//        System.out.println(result);
    }
}
