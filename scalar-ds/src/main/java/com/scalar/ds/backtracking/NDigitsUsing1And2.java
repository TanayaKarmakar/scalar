package com.scalar.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class NDigitsUsing1And2 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int n = 4;
        List<String> result = generate(nums, n);
        System.out.println(result);
    }

    private static List<String> generate(int[] nums, int n) {
        List<String> digits = new ArrayList<>();
        generateRec(nums, n, digits, "");
        return digits;
    }

    private static void generateRec(int[] nums, int n, List<String> digits, String currentStr) {
        if(n == 0) {
            digits.add(currentStr);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            generateRec(nums, n - 1, digits, currentStr + nums[i]);
        }
    }
}
