package com.scalar.ds.sorting.advanced.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 01/05/22
 * @project scalar
 */
public class AlternatePositiveNegativeElements {
    private static int[] solve(int[] A) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0)
                negative.add(A[i]);
            else
                positive.add(A[i]);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < positive.size() && j < negative.size()) {
            A[k++] = negative.get(j);
            A[k++] = positive.get(i);
            i++;
            j++;
        }

        while(i < positive.size()) {
            A[k++] = positive.get(i);
            i++;
        }

        while(j < negative.size()) {
            A[k++] = negative.get(j);
            j++;
        }

        return A;

    }

    public static void main(String[] args) {

    }
}
