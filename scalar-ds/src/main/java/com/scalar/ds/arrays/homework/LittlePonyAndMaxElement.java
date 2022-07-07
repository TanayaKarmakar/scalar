package com.scalar.ds.arrays.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class LittlePonyAndMaxElement {
    private static int searchElement(ArrayList<Integer> A, int B) {
        int start = 0;
        int end = A.size() - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A.get(mid) == B)
                return mid;
            else if(A.get(mid) > B)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int solve(ArrayList<Integer> A, int B) {
        if(A.isEmpty())
            return -1;
        Collections.sort(A);
        int ans = searchElement(A, B);
        if(ans == -1)
            return -1;

        int i = A.size() - 1;
        int count = 0;
        while(A.get(i) > B) {
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
