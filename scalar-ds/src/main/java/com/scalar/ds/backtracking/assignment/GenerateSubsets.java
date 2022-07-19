package com.scalar.ds.backtracking.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class GenerateSubsets {

    static class ValueComparator implements Comparator<ArrayList<Integer>> {

        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(o1.size() == 0)
                return o1.size() - o2.size();
            if(o2.size() == 0)
                return o1.size() - o2.size();
            int m = o1.size();
            int n = o2.size();
            int i = 0;
            int j = 0;
            while(i < m && j < n) {
                if(o1.get(i) < o2.get(j))
                    return o1.get(i) - o2.get(j);
                else if(o1.get(i) > o2.get(j))
                    return o1.get(i) - o2.get(j);
                i++;
                j++;
            }

            return 0;
        }
    }

    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currentSubset = new ArrayList<>();
        generateSubsets(A, 0, subsets, currentSubset);
        Collections.sort(subsets, new ValueComparator());
        return subsets;
    }

    private static void generateSubsets(ArrayList<Integer> a, int indx, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currentSubset) {
        if(indx >= a.size()) {
            ArrayList<Integer> newList = new ArrayList<>(currentSubset);
            subsets.add(newList);
            return;
        }

        generateSubsets(a, indx + 1, subsets, currentSubset);
        currentSubset.add(a.get(indx));
        generateSubsets(a, indx + 1, subsets, currentSubset);
        currentSubset.remove(currentSubset.get(currentSubset.size() - 1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ArrayList<ArrayList<Integer>> result = subsets(a);

        System.out.println(result);
    }
}
