package com.scalar.subsetsubseq.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class SpecialSubsequence {
    private static int solve(String A) {
        int MOD = 1000000007;
        long count = 0;
        long ans = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'A')
                count++;
            else if(A.charAt(i) == 'G')
                ans += count;
        }

        return (int)(ans % MOD);
    }

    public static void main(String[] args) {
        String str = "GAB";

        System.out.println(solve(str));

        str = "ABCGAG";

        System.out.println(solve(str));

        str = "ICA";

        System.out.println(solve(str));
    }
}
