package com.scalar.strings.advanced.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 25/05/22
 * @project scalar
 */
public class BoringSubstring {
    private static int solve(String A) {
        List<Character> odd = new ArrayList<>();
        List<Character> even = new ArrayList<>();

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch % 2 == 0) {
                even.add(ch);
            } else {
                odd.add(ch);
            }
        }

        char first = odd.get(0);

        int indx = -1;
        for(int i = 0; i < even.size(); i++) {
            if(Math.abs(first - even.get(i)) > 1) {
                indx = i;
                break;
            }
        }

        if(indx == -1)
            return 0;

        return 1;
    }

    public static void main(String[] args) {

    }
}
