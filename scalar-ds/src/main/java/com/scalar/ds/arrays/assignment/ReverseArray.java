package com.scalar.ds.arrays.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class ReverseArray {
    private static ArrayList<Integer> solve(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = A.size() - 1; i >= 0; i--) {
            result.add(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
