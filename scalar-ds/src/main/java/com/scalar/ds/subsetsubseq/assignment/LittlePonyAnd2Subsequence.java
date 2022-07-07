package com.scalar.ds.subsetsubseq.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class LittlePonyAnd2Subsequence {
    private static String solve(String A) {
        int n = A.length();
        long totalVal = (long) Math.pow(2, n);

        List<String> list = new ArrayList<>();
        for(long i = 0; i < totalVal; i++) {
            long temp = i;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    sb.append(A.charAt(j));
                }
                temp = temp >> 1;
                j++;
            }
            if(sb.toString().length() >= 2) {
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    public static void main(String[] args) {
        String str = "abcdsfhjagj";

        String ans = solve(str);

        System.out.println(ans);

    }
}
