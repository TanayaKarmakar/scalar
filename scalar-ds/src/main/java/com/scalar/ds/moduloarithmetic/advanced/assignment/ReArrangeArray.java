package com.scalar.ds.moduloarithmetic.advanced.assignment;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 06/04/22
 * @project scalar
 */
public class ReArrangeArray {
    private static void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for(int i = 0; i < n; i++) {
            A.set(i, A.get(i) * n);
        }

        for(int i = 0; i < n; i++) {
            int oldVal = A.get(i) / n;
            int newVal = A.get(oldVal) / n;
            int result = oldVal * n + newVal;
            A.set(i, result);
        }

        //System.out.println(A);

        for(int i = 0; i < n; i++) {
            int val = A.get(i) % n;
            A.set(i, val);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        arrange(list);

        System.out.println(list);
    }
}
