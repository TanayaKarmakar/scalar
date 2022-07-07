package com.scalar.ds.hashing.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 13/02/22
 * @project scalar-ds
 */
public class ColorFulNumber {
    private static int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        String str = String.valueOf(A);
        for(int i = 0; i < str.length(); i++) {
            int currentVal = 1;
            for(int j = i; j < str.length(); j++) {
                currentVal *= Integer.parseInt(str.charAt(j) + "");
                if(set.contains(currentVal)) {
                    return 0;
                } else {
                    set.add(currentVal);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
