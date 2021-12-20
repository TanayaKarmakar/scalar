package com.scalar.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 19/12/21
 * @project scalar-ds
 */
public class CommonElements {
    private static List<Integer> solve(List<Integer> A, List<Integer> B) {
        if((A == null || A.isEmpty()) || (B == null || B.isEmpty()))
            return new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);

        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();
        while(i < A.size() && j < B.size()) {
            if(A.get(i) == B.get(j)) {
                result.add(A.get(i));
                i++;
                j++;
            } else if(A.get(i) < B.get(i))
                i++;
            else
                j++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,2,2,1);
        List<Integer> B = Arrays.asList(2,3,1,2);

        List<Integer> result = solve(A, B);
        System.out.println(result);
    }
}
