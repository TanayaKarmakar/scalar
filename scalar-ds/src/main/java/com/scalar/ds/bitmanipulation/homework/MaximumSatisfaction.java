package com.scalar.ds.bitmanipulation.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 05/02/22
 * @project scalar-ds
 */
class ValueComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return numSetBits(o1) - numSetBits(o2);
    }

    private int numSetBits(Integer num) {
        int count = 0;
        while(num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}

public class MaximumSatisfaction {
    private static int solve(List<Integer> A) {
        Collections.sort(A, new ValueComparator());

        int size = A.size();
        int first = A.get(size - 1);
        int second = A.get(size - 2);
        int third = A.get(size - 3);
        int fourth = A.get(size - 4);

        return 0;

        //return (first & second & third & fourth);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 15, 4, 14);

        int ans = solve(list);

        System.out.println(ans);
    }
}
