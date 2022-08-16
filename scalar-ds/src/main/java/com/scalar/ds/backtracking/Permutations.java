package com.scalar.ds.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 22/07/22
 * @project scalar
 */
public class Permutations {
    private static Set<Integer> selectedElements;
    private static int[] permutations;

    private static void printPermutations(int[] nums) {
        selectedElements = new HashSet<>();
        int n = nums.length;
        permutations = new int[n];
        permutationRec(nums, 0);
    }

    private static void permutationRec(int[] nums, int indx) {
        if(indx >= nums.length) {
            System.out.println(Arrays.toString(permutations));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!selectedElements.contains(nums[i])) {
                selectedElements.add(nums[i]);
                permutations[indx] = nums[i];
                permutationRec(nums, indx + 1);
                selectedElements.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        printPermutations(nums);
    }
}
