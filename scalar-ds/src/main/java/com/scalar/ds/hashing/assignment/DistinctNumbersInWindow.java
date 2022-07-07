package com.scalar.ds.hashing.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar-ds
 */
public class DistinctNumbersInWindow {
    private static int[] dNums(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < B) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            right++;
        }

        List<Integer> res = new ArrayList<>();
        res.add(map.size());

        int n = A.length;
        while(right < n) {
            int val = map.get(A[left]);
            val--;
            if(val == 0)
                map.remove(A[left]);
            else
                map.put(A[left], val);
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            res.add(map.size());
            right++;
            left++;
        }

        int[] finalAns = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            finalAns[i] = res.get(i);
        }
        return finalAns;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4, 3};
        int B = 3;

        int[] ans = dNums(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
