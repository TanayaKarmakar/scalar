package com.scalar.bitmanipulation.homework;

import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 05/02/22
 * @project scalar-ds
 */
public class MaximumSatisfaction {
    private static int solve(List<Integer> A) {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < A.size() - 3; i++) {
            int currentVal = (A.get(i) & A.get(i + 1) & A.get(i + 2) & A.get(i + 3));
            ans = Integer.max(ans, currentVal);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 15, 4, 14);

        int ans = solve(list);

        System.out.println(ans);
    }
}
