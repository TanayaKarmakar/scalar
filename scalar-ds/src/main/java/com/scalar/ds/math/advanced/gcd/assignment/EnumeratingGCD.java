package com.scalar.ds.math.advanced.gcd.assignment;

/**
 * @author t0k02w6 on 07/04/22
 * @project scalar
 */
public class EnumeratingGCD {
    private static String solve(String A, String B) {
        if(A.equals(B))
            return A;
        return "1";
    }

    public static void main(String[] args) {
        String A = "678728391838182039102";
        String B = "678728391838182039103";

        String ans = solve(A, B);

        System.out.println(ans);
    }
}
