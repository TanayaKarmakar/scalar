package com.scalar.ds.arrays.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class GoodPair {
    private static int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet<>();
        for(Integer el: A) {
            if(set.contains(B - el))
                return 1;
            set.add(el);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
