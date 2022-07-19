package com.scalar.ds.backtracking.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/07/22
 * @project scalar
 */
public class Sixlets {
    private static int count = 0;

    private static int solve(ArrayList<Integer> A, int B) {
        count = 0;
        int target = 1000;
        List<Integer> current = new ArrayList<>();
        subseqRec(A, 0, current, target, B);
        return count;
    }

    private static void subseqRec(ArrayList<Integer> a, int indx, List<Integer> current, int target, int b) {
        if(target >= 0) {
            if(current.size() == b) {
                count++;
                return;
            }
        }
        if(indx >= a.size() || current.size() > b)
            return;

        subseqRec(a, indx + 1, current, target, b);
        current.add(a.get(indx));
        subseqRec(a, indx + 1, current, target - a.get(indx), b);
        current.remove(current.get(current.size() - 1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(8);
        //nums.add(11);
        int B = 2;
        int ans = solve(nums, B);

        System.out.println(ans);
    }
}
