package com.scalar.ds.backtracking.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.swap;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class Permutations {
    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        permuteRec(A, result, 0, A.size() - 1);
        return new ArrayList<>(result);
    }

    private static void permuteRec(ArrayList<Integer> a, Set<ArrayList<Integer>> result, int left, int right) {
        if(right >= a.size())
            return;
        for(int i = left; i <= right; i++) {
            swap(a, i, left);
            ArrayList<Integer> newList = new ArrayList<>(a);
            result.add(newList);
            permuteRec(a, result, left + 1, right);
            swap(a, i, left);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ArrayList<ArrayList<Integer>> result = permute(a);

        System.out.println(result);
    }
}
