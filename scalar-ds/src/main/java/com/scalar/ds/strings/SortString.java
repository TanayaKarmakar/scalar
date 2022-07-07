package com.scalar.ds.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class SortString {
    private static void sortString(String[] strs) {
        Arrays.sort(strs, new StringComparator());
    }

    public static void main(String[] args) {
        String[] strs = {"a","b","b","a","d","c","f","z","y","x"};

        sortString(strs);
        System.out.println(Arrays.toString(strs));
    }
}
