package com.scalar.ds.backtracking.assignment;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class CombinationSum {
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


    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        Set<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        combinationSumRec(A, 0, result, current, B);
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>(result);
        Collections.sort(finalResult, new ValueComparator());
        return finalResult;
    }

    private static void combinationSumRec(ArrayList<Integer> a, int indx, Set<ArrayList<Integer>> result, ArrayList<Integer> current, int b) {
        if(b < 0)
            return;
        if(b == 0) {
            ArrayList<Integer> newList = new ArrayList<>(current);
            result.add(newList);
            return;
        }


        for(int i = indx; i < a.size(); i++) {
            current.add(a.get(i));
            combinationSumRec(a, i, result, current, b - a.get(i));
            current.remove(current.get(current.size() - 1));
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(6);
        nums.add(7);
        int B = 7;

        ArrayList<ArrayList<Integer>> result = combinationSum(nums, B);
        System.out.println(result);

    }
}
