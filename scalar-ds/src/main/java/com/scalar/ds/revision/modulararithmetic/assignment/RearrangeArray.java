package com.scalar.ds.revision.modulararithmetic.assignment;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 28/08/22
 * @project scalar-ds
 */
public class RearrangeArray {
    private static void arrange(ArrayList<Integer> A) {
        int n = A.size();
       for(int i = 0; i < n; i++) {
           A.set(i, A.get(i) * n);
       }

       for(int i = 0; i < n; i++) {
           int oldValue = A.get(i) / n;
           int newValue = A.get(oldValue)/ n;
           int result = oldValue * n + newValue;
           A.set(i, result);
       }

       for(int i = 0; i < n; i++) {
           A.set(i, A.get(i) % n);
       }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);

        arrange(a);

        System.out.println(a);
    }
}
