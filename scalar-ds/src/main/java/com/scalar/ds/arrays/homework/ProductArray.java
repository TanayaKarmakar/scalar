package com.scalar.ds.arrays.homework;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 14/01/22
 * @project scalar-ds
 */
public class ProductArray {
    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];

        int leftVal = 1;

        for(int i = 0; i < A.size(); i++) {
            left[i] = leftVal;
            leftVal = leftVal * A.get(i);
        }

        int rightVal = 1;
        for(int i = A.size() - 1; i >= 0; i--) {
            right[i] = rightVal;
            rightVal = rightVal * A.get(i);
        }

        ArrayList<Integer> product = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            product.add(left[i] * right[i]);
        }

        return product;
    }
}
