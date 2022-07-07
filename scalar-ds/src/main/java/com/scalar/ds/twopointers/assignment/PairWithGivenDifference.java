package com.scalar.ds.twopointers.assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class PairWithGivenDifference {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int i = 0;
        int j = 0;
        //int count = 0;

        Set<Pair> set = new HashSet<>();

        while(i < n && j < n) {
            int diff = A[j] - A[i];
            if(diff == B) {
                if(i != j) {
                    set.add(new Pair(A[i], A[j]));
                }
                i++;
                //j++;
            } else if(diff > B)
                i++;
            else
                j++;
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2};
        int B = 0;
        int ans = solve(nums, B);
        System.out.println(ans);
    }
}
