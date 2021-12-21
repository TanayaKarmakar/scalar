package com.scalar.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 21/12/21
 * @project scalar-ds
 */
public class MaxMod {
    private static int solve(ArrayList<Integer> A) {
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.size(); j++) {
                if(A.get(j) == 0)
                    continue;
                int currentMod = A.get(i) % A.get(j);
                maxVal = Integer.max(maxVal, currentMod);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(44);
        list.add(3);

        int ans = solve(list);

        System.out.println(ans);
    }
}
