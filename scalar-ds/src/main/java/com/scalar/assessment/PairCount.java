package com.scalar.assessment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 19/12/21
 * @project scalar-ds
 */
public class PairCount {
    private static int solve(List<Integer> A, int B) {
        if(A == null || A.isEmpty())
            return 0;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(Integer val: A) {
            if(set.contains(B - val))
                count++;
            set.add(val);
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,2,3,2,1);
        int B = 5;

        int count = solve(A, B);
        System.out.println(count);

        A = Arrays.asList(1,1,1);
        B = 2;

        count = solve(A, B);
        System.out.println(count);
    }
}
