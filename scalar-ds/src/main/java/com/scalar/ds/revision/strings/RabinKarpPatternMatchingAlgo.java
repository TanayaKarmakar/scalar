package com.scalar.ds.revision.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/09/22
 * @project scalar-ds
 */
public class RabinKarpPatternMatchingAlgo {

    private static List<Integer> matchPattern(String pattern, String string) {
        int left = 0;
        int right = 0;
        int n = string.length();
        int m = pattern.length();
        int patternHash = 0;
        int stringHash = 0;
        int p = 27;
        int mod = 1000000007;
        List<Integer> result = new ArrayList<>();
        for(right = 0; right < m; right++) {
            int patternValue = (pattern.charAt(right) - 'a') + 1;
            int stringValue = (string.charAt(right) - 'a') + 1;
            patternHash = ((((patternHash % mod) * (p % mod)) % mod) + patternValue) % mod;
            stringHash = ((((stringHash % mod) * (p % mod)) % mod) + stringValue) % mod;
        }

        while(right < n) {
            if(patternHash == stringHash) {
                String stringFrag = string.substring(left, right);
                if(stringFrag.equals(pattern)) {
                    result.add(left);
                }
            }
            int stringValue = (string.charAt(right) - 'a') + 1;
            stringHash = (stringHash / p);
            int value = (int) (((stringValue % mod) * Math.pow(p, m - 1) % mod) % mod);
            stringHash = (stringHash + value) % mod;
            stringValue = (string.charAt(left) - 'a') + 1;
            stringHash = ((stringHash % mod) - (stringValue % mod)) % mod;
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abcxyclshfdfgdgxyclfdfsdfxycl";

        String pattern = "xycl";

        List<Integer> result = matchPattern(pattern, str);

        System.out.println(result);

    }
}
