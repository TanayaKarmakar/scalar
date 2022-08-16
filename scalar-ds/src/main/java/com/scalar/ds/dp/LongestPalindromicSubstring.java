package com.scalar.ds.dp;

/**
 * @author t0k02w6 on 11/08/22
 * @project scalar
 */
public class LongestPalindromicSubstring {
    private static int lps(String str) {
        int n = str.length();
        boolean[][] lps = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            lps[i][i] = true;
        }

        int maxLen = 1;
        for(int l = 2; l <= n; l++) {
            int i = 0;
            int j = l - 1;
            while(j < n) {
                if(str.charAt(i) == str.charAt(j)) {
                    lps[i][j] = lps[i + 1][j - 1];
                    if(lps[i][j]) {
                        maxLen = Integer.max(maxLen, (j - i) + 1);
                    }
                } else {
                    lps[i][j] = false;
                }
                j++;
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abbcecba";
        int ans = lps(str);

        System.out.println(ans);
    }
}
