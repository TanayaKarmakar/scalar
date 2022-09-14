package com.scalar.ds.revision.strings.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/09/22
 * @project scalar-ds
 */
public class PeriodOfAString {

    private static int solve(String A) {
        int n = A.length();
        int[] z = new int[n];
        z[0] = n;

        int count = 0;
        int s = 0;
        int e = 0;
        for(int i = 1; i < n; i++) {
            if(i > e) {
                s = e = i;
                count = 0;
                while(e < n && A.charAt(e) == A.charAt(e - s)) {
                    e++;
                    count++;
                }
                z[i] = count;
                e--;
            } else {
                if(i + z[i - s] <= e) {
                    z[i] = z[i - s];
                } else {
                    count = 0;
//                    if(i - s > 0)
//                        count = z[i - s];
                    s = i;
                    e++;
                    while(e < n && A.charAt(e) == A.charAt(e - s)) {
                        count++;
                        e++;
                    }
                    z[i] = count;
                    e--;
                }
            }
        }

        System.out.println(Arrays.toString(z));

        for(int i = 1; i < z.length; i++) {
            if(z[i] + i == z.length)
                return i;
        }
        return z[0];
    }

    public static void main(String[] args) {
        String str = "abcaabcaab";
        int ans = solve(str);

        System.out.println(ans);
    }
}
