package com.scalar.ds.arrays;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 21/12/21
 * @project scalar-ds
 */
public class SumOfAdjacentNumbersAlwaysEven {
    private static int solve(ArrayList<Integer> A) {
        int[] isOdd = new int[A.size()];

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) % 2 != 0)
                isOdd[i] = 1;
        }

        int count = 0;
        for(int i = 1; i < A.size(); i++) {
            if(isOdd[i] != isOdd[i - 1] && isOdd[i - 1] != -2) {
                count++;
                isOdd[i] = -2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int count = solve(list);

        System.out.println(count);
     }
}
