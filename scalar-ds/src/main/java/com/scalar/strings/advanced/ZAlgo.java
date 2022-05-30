package com.scalar.strings.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 25/05/22
 * @project scalar-ds
 */
public class ZAlgo {
    private static int[] zAarr(String str) {
        int n = str.length();
        int[] z = new int[n];

        z[0] = n;
        int count = 0;
        int s = 0;
        int e = 0;
        for(int i = 1; i < n; i++) {
            if(i > e) {
                s = e = i;
                count = 0;
                while(e < n && str.charAt(e) == str.charAt(e - s)) {
                    e++;
                    count++;
                }
                e--;
                z[i] = count;
            } else {
                if(i + z[i - s] <= e) {
                    z[i] = z[i - s];
                } else {
                    count = 0;
                    if(i - s > 0)
                        count = z[i - s];
                    s = i;
                    while(e < n && str.charAt(e) == str.charAt(e - s)) {
                        e++;
                        count++;
                    }
                    e--;
                    z[i] = count;
                }
            }
        }
        return z;
    }

    public static void main(String[] args) {
        String str = "xxyaxxyaxxyazxxyaz";

        int[] z = zAarr(str);

        System.out.println(Arrays.toString(z));
    }
}
