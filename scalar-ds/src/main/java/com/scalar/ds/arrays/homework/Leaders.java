package com.scalar.ds.arrays.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class Leaders {
    private static int[] solve(int[] A) {
        int n = A.length;

        List<Integer> list = new ArrayList<>();
        list.add(A[n - 1]);

        int max = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(A[i] > max) {
                list.add(0, A[i]);
                max = A[i];
            }
        }

        int[] res = new int[list.size()];
        int k = 0;
        for(Integer el: list) {
            res[k++] = el;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        int[] res = solve(nums);

        System.out.println(Arrays.toString(res));
    }
}
