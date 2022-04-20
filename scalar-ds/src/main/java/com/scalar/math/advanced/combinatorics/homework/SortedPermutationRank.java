package com.scalar.math.advanced.combinatorics.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 11/04/22
 * @project scalar
 */
public class SortedPermutationRank {

    private static void permuteRec(char[] arr, int indx, List<String> result) {
        if(indx == arr.length) {
            String str = new String(arr);
            result.add(str);
            return;
        }

        for(int i = indx; i < arr.length; i++) {
            swap(arr, indx, i);
            permuteRec(arr, indx + 1, result);
            swap(arr, indx, i);
        }
    }

    private static void swap(char[] arr, int indx, int i) {
        char ch = arr[indx];
        arr[indx] = arr[i];
        arr[i] = ch;
    }


    private static int findRank(String A) {
        List<String> permutations = new ArrayList<>();
        permuteRec(A.toCharArray(), 0, permutations);

        System.out.println(permutations);
        return 0;
    }

    public static void main(String[] args) {
        String str = "acb";
        findRank(str);
    }
}
