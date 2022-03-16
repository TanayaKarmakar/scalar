package com.scalar.subsetsubseq.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
class ListComparator implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }
}

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int n = A.size();
        int totalVal = (int)Math.pow(2, n);
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();

        for(int i = 0; i < totalVal; i++) {
            int k = i;
            ArrayList<Integer> result = new ArrayList<>();
            int j = 0;
            while(k != 0) {
                if((k & 1) == 1) {
                    result.add(A.get(j));
                }
                k = k >> 1;
                j++;
            }
            //System.out.println(result);
            finalResult.add(result);
        }
        Collections.sort(finalResult, new ListComparator());
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {15, 20, 12, 19, 4};
    }
}
