package com.scalar.hashing.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 11/02/22
 * @project scalar
 */
public class CommonElements {
    private static int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        List<Integer> commonElements = new ArrayList<>();
        for(int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i])) {
                int val = map.get(B[i]);
                val--;
                if(val == 0) {
                   map.remove(B[i]);
                } else {
                    map.put(B[i], val);
                }
                commonElements.add(B[i]);
            }
        }

        int[] result = new int[commonElements.size()];
        int k = 0;
        for(Integer el: commonElements) {
            result[k++] = el;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};

        int[] result = solve(A, B);

        System.out.println(Arrays.toString(result));
    }
}
