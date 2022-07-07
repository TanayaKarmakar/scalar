package com.scalar.ds.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author t0k02w6 on 07/02/22
 * @project scalar-ds
 */
class FactorComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int countn1 = getFactorCount(o1);
        int countn2 = getFactorCount(o2);
        if(countn1 == countn2)
            return (o1 - o2);
        return (countn1 - countn2);
    }

    private int getFactorCount(int n1) {
        int count = 0;
        int val = (int) Math.sqrt(n1);
        while(val > 0) {
            if(n1 % val == 0) {
                if(n1 % val == val)
                    count++;
                else
                    count+=2;
            }
            val--;
        }
        return count;
    }
}

public class SortAnArrayBasedOnNumberOfFactors {
    public static void main(String[] args) {
        Integer[] nums = {1,5,3,6,9,12,15};

        Arrays.sort(nums, new FactorComparator());

        System.out.println(Arrays.toString(nums));
    }
}
