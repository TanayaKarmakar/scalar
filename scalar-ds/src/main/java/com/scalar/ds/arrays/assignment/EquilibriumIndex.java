package com.scalar.ds.arrays.assignment;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 14/01/22
 * @project scalar-ds
 */
public class EquilibriumIndex {
    private static int solve(ArrayList<Integer> A) {
        if(A.isEmpty())
            return -1;
        int total = 0;
        for(Integer el: A) {
            total += el;
        }

        int right = total;
        int left = 0;
        for(int i = 0; i < A.size(); i++) {
            right = right - A.get(i);
            if(right == left)
                return i;
            left = left + A.get(i);
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
