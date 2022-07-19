package com.scalar.ds.backtracking.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        Set<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        combinationRec(A, 0, result, current, B);
        return new ArrayList<>(result);
    }

    private static void combinationRec(ArrayList<Integer> A, int indx, Set<ArrayList<Integer>> result,
                                       ArrayList<Integer> current, int B) {
        if(B == 0) {
            ArrayList<Integer> newList = new ArrayList<>(current);
            result.add(newList);
            return;
        }
        if(indx >= A.size())
            return;

        combinationRec(A, indx + 1, result, current, B);
        current.add(A.get(indx));
        combinationRec(A, indx + 1, result, current, B - A.get(indx));
        current.remove(current.get(current.size() - 1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);

        int B = 8;

        ArrayList<ArrayList<Integer>> result = combinationSum(a, B);
        System.out.println(result);
    }
}
