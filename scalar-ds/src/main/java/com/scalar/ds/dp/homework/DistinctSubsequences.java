package com.scalar.ds.dp.homework;


/**
 * @author t0k02w6 on 12/09/22
 * @project scalar-ds
 */
public class DistinctSubsequences {
    //private static final int mod = 1000000007;

    private static int numDistinct(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                     dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
//        Map<String, Long> memo = new HashMap<>();
//        return (int)(numDistinctMemo(A, B, A.length() - 1, B.length() - 1, memo) % mod);
    }

//    private static long numDistinctMemo(String a, String b, int i, int j, Map<String, Long> memo) {
//        if(i < 0)
//            return 0;
//        if(j == 0) {
//            if(a.charAt(i) == b.charAt(j))
//                return 1;
//            else
//                return 0;
//        }
//        String key = i + ":" + j;
//        if(!memo.containsKey(key)) {
//            long value = 0;
//            if(a.charAt(i) == b.charAt(j)) {
//                value += numDistinctMemo(a, b, i - 1, j - 1, memo);
//                value += numDistinctMemo(a, b, i - 1, j, memo);
//            } else {
//                value += numDistinctMemo(a, b, i - 1, j, memo);
//            }
//            memo.put(key, value);
//        }
//        return memo.get(key);
//    }
//    private static int numDistinct(String A, String B) {
//        return numDistinctRec(A, B, A.length() - 1, B.length() - 1);
//    }
//
//    private static int numDistinctRec(String a, String b, int i, int j) {
//        if(i < 0)
//            return 0;
//        if(j == 0) {
//            if(a.charAt(i) == b.charAt(j))
//                return 1;
//            else
//                return 0;
//        }
//        int count = 0;
//        if(a.charAt(i) == b.charAt(j)) {
//            int option1 = numDistinctRec(a, b, i - 1, j - 1);
//            int option2 = numDistinctRec(a, b, i - 1, j);
//            count += option1 + option2;
//        } else {
//            count += numDistinctRec(a, b, i - 1, j);
//        }
//        return count;
//    }

    public static void main(String[] args) {
        String str = "abc";
        String pattern = "abc";
        int ans = numDistinct(str, pattern);

        System.out.println(ans);
    }
}
