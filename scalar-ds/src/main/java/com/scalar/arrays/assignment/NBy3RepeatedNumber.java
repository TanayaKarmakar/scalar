package com.scalar.arrays.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 05/02/22
 * @project scalar-ds
 */
public class NBy3RepeatedNumber {
    private static int repeatedNumber(final List<Integer> a) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;

        for(Integer n: a) {
            if(candidate1 != null && candidate1.equals(n)) {
                count1++;
            } else if(candidate2 != null && candidate2.equals(n)) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = n;
                count1++;
            } else if(count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(Integer n: a) {
            if(candidate1 != null && candidate1.equals(n))
                count1++;
            if(candidate2 != null && candidate2.equals(n))
                count2++;
        }

        if(count1 > a.size() / 3)
            return candidate1;
        else if (count2 > a.size() / 3)
            return  candidate2;
        else
            return -1;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 1, 1);

        int ans = repeatedNumber(nums);

        System.out.println(ans);
    }
}
