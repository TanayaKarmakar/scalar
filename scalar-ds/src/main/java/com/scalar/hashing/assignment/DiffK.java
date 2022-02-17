package com.scalar.hashing.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 17/02/22
 * @project scalar-ds
 */
public class DiffK {
    private static int diffPossible(final int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for(int i = 0; i < A.length; i++) {
            int val = B + A[i];
            if(map.containsKey(val)) {
                if ((val == A[i] && map.get(val) > 1) || (val != A[i]))
                    return 1;

            }

           // (val == A[i] && map.get(val) > 1))
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums = {0};
        int B = 0;

        int ans = diffPossible(nums, B);

        System.out.println(ans);
    }
}
