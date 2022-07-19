package com.scalar.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class GenerateSubsets {
    private static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateSubsetsRec(nums, 0, result, current);
        return result;
    }

    private static void generateSubsetsRec(int[] nums, int i, List<List<Integer>> result, List<Integer> current) {
        if(i >= nums.length) {
            List<Integer> newList = new ArrayList<>(current);
            result.add(newList);
            return;
        }

        generateSubsetsRec(nums, i + 1, result, current);
        current.add(nums[i]);
        generateSubsetsRec(nums, i + 1, result, current);
        current.remove(current.get(current.size() - 1));

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = generateSubsets(nums);

        System.out.println(result);
    }
}
