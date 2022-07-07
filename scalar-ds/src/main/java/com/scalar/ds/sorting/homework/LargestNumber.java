package com.scalar.ds.sorting.homework;

import java.util.*;

/**
 * @author t0k02w6 on 08/02/22
 * @project scalar-ds
 */
class NumberComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String option1 = o1 + o2;
        String option2 = o2 + o1;
        return option2.compareTo(option1);
    }
}

public class LargestNumber {
    private static String largestNumber(final int[] A) {
        List<String> list = new ArrayList<>();
        boolean isZero = true;
        for(Integer a: A) {
            if(a != 0) {
                isZero = false;
            }
            list.add(String.valueOf(a));
        }
        if(isZero)
            return "0";
        Collections.sort(list, new NumberComparator());

        StringBuilder sb = new StringBuilder();
        for(String el: list) {
            sb.append(el);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] A = {3, 30, 34, 5, 9};
        String str = largestNumber(A);

        System.out.println(str);
    }
}
