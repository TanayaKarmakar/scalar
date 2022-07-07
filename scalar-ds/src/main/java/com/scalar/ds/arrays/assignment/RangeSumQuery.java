package com.scalar.ds.arrays.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 14/01/22
 * @project scalar-ds
 */
public class RangeSumQuery {
    private static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> result = new ArrayList<>();

        List<Long> prefix = new ArrayList<>();
        prefix.add((long)A.get(0));

        for(int i = 1; i < A.size(); i++) {
            prefix.add(prefix.get(i - 1) + A.get(i));
        }

        for(ArrayList<Integer> current: B) {
            int left = current.get(0);
            int right = current.get(1);

            long val = prefix.get(right - 1);
            if(left - 2 >= 0)
                val = val - prefix.get(left - 2);
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
