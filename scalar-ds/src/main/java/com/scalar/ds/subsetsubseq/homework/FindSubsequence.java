package com.scalar.ds.subsetsubseq.homework;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class FindSubsequence {
    private static String solve(String A, String B) {
        int m = A.length();
        int n = B.length();

        int i = 0;
        int j = 0;
        while(j < n && i < m) {
            if(A.charAt(i) == B.charAt(j))
                i++;
            j++;
        }
        return i == m ? "YES": "NO";
    }

    public static void main(String[] args) {

    }
}
