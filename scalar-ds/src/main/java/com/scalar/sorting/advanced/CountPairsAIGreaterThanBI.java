package com.scalar.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/04/22
 * @project scalar
 */
public class CountPairsAIGreaterThanBI {

    private static int countPairs(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int m = a.length;
        int n = b.length;
        int i = m - 1;
        int j = n - 1;
        int count = 0;
        while(i >= 0 && j >= 0) {
            if(a[i] > b[j]) {
                count += (j - 0 + 1);
                i--;
            } else {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {7,3,5};
        int[] b = {2,0,6};

        int ans = countPairs(a, b);

        System.out.println(ans);

        a = new int[] {2,4,4,5};
        b = new int[] {3,2,9};

        ans = countPairs(a, b);

        System.out.println(ans);
    }
}
