package com.scalar.sorting.advanced.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
class ValueComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String x = String.valueOf(o1) + String.valueOf(o2);
        String y = String.valueOf(o2) + String.valueOf(o1);
        return y.compareTo(x);
    }
}

public class LargestNumber {
    private static String largestNumber(final int[] A) {
        List<Integer> aList = new ArrayList<>();
        for(int a: A) {
            aList.add(a);
        }

        Collections.sort(aList, new ValueComparator());
        StringBuilder sb = new StringBuilder();
        for(Integer el: aList) {
            sb.append(el);
        }
        int i = 0;
        while(i < sb.length() - 1 && sb.charAt(i) == '0')
            i++;
        return sb.substring(i);
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String ans = largestNumber(nums);

        System.out.println(ans);
    }
}
