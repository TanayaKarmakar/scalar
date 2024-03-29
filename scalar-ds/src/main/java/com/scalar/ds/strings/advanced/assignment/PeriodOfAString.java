package com.scalar.ds.strings.advanced.assignment;

/**
 * @author t0k02w6 on 26/05/22
 * @project scalar
 */
public class PeriodOfAString {
    private static int solve(String A) {
        int n = A.length();
        int[] z = new int[n];

        z[0] = n;
        int s = 0;
        int e = 0;
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(i > e) {
                s = e = i;
                count = 0;
                while (e < n && A.charAt(e) == A.charAt(e - s)) {
                    e++;
                    count++;
                }
                z[i] = count;
                e--;
            } else {
                if(i + z[i - s] <= e) {
                    z[i] = z[i - s];
                } else {
                    if(i - s == 0) {
                        count = 0;
                    } else {
                        count = z[i - s];
                    }
                    s = i;
                    e++;
                    while (e < n && A.charAt(e) == A.charAt(e - s)) {
                        e++;
                        count++;
                    }
                    z[i] = count;
                    e--;
                }
            }
        }

        for(int i = z.length - 1; i >= 0; i--) {
            if(i + z[i] == z.length)
                return z[i];
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
