package com.scalar.arrays.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 13/01/22
 * @project scalar-ds
 */
public class MultipleLeftRotations {
    private static void reverse(List<Integer> list, int start, int end) {
        while(start < end) {
            int tmp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, tmp);
            start++;
            end--;
        }
    }

    private static void rotateLeftBy(List<Integer> list, int b) {
        if(b > list.size())
            b = b % list.size();
        reverse(list, 0, list.size() - 1);
        reverse(list, 0, list.size() - b - 1);
        reverse(list, list.size() - b, list.size() - 1);
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Integer el: B) {
            ArrayList<Integer> temp = new ArrayList<>(A);
            rotateLeftBy(temp, el);
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(3);

        ArrayList<ArrayList<Integer>> result = solve(list, B);
        System.out.println(result);
    }
}
