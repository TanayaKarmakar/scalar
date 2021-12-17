package com.scalar.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 17/12/21
 * @project scalar-ds
 */
public class SubsetRecursion {
    private static List<List<Integer>> ans;

    private static void subset(int[] arr, List<Integer> frag, int indx) {
        if(indx == arr.length) {
            ans.add(frag);
            return;
        }

        List<Integer> frag1 = new ArrayList<>();
        List<Integer> frag2 = new ArrayList<>();
        frag1.addAll(frag);
        frag2.addAll(frag);
        frag2.add(arr[indx]);
        subset(arr, frag1, indx + 1);
        subset(arr, frag2, indx + 1);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ans = new ArrayList<>();
        subset(arr, new ArrayList<>(), 0);

        System.out.println(ans);
    }
}
