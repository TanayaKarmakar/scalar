package com.scalar.ds.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 11/08/22
 * @project scalar
 */
public class WordBreakProblem {
    private static boolean isWordBreak(String str, String[] dict) {
        Set<String> wordSet = new HashSet<>();
        for(String el: dict) {
            wordSet.add(el);
        }

        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                String current = str.substring(j, i);
                if(wordSet.contains(current)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String str = "applepenapple";
        String[] dict = {"apple", "pen"};

        boolean ans = isWordBreak(str, dict);

        System.out.println(ans);
    }
}
