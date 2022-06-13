package com.scalar.strings.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class RabinKarpPatternMatching {
    private static boolean isEqual(String pattern, String txt, int l, int r) {
        for(int i = 0, j = l; i < pattern.length() && j <= r; i++, j++) {
            if(pattern.charAt(i) != txt.charAt(j))
                return false;
        }
        return true;
    }

    private static List<Integer> findPattern(String str, String pattern) {
        List<Integer> ans = new ArrayList<>();
        long patternValue = 0;
        long  textValueCurrentWindow = 0;
        int l = 0;
        int r = 0;
        int p = 26;
        int MOD = 1000000007;
        int m = pattern.length();

        for(r = 0; r < pattern.length(); r++) {
            int ch = pattern.charAt(r) - 'a';
            int ch1 = str.charAt(r) - 'a';
            patternValue = ((patternValue % MOD) + (ch * (long) Math.pow(p, r)) % MOD) % MOD;
            textValueCurrentWindow = ((textValueCurrentWindow % MOD) + (ch1 * (long) Math.pow(p, r)) % MOD) % MOD;
        }

        while(r < str.length()) {
            if(patternValue == textValueCurrentWindow && isEqual(pattern, str, l, r)) {
                ans.add(l);
            }
            int prevValue = str.charAt(l) - 'a';
            textValueCurrentWindow = (textValueCurrentWindow - prevValue) / p;
            int nextValue = str.charAt(r) - 'a';
            textValueCurrentWindow = ((textValueCurrentWindow % MOD)
                    + (nextValue * (long)Math.pow(p, m - 1)) % MOD) % MOD;
            l++;
            r++;
        }

        if(patternValue == textValueCurrentWindow && isEqual(pattern, str, l, r)) {
            ans.add(l);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abxycldhgdabxyclhhdfdfxycl";
        String pattern = "xycl";

        List<Integer> ans = findPattern(str, pattern);

        System.out.println(ans);
    }
}
