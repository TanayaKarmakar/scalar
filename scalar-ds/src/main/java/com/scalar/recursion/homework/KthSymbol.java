package com.scalar.recursion.homework;

/**
 * @author t0k02w6 on 21/02/22
 * @project scalar
 */
public class KthSymbol {
    private static String formString(String ss, int A) {
        if(A == 1)
            return ss;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length(); i++) {
            if(ss.charAt(i) == '0')
                sb.append("01");
            else
                sb.append("10");
        }
        return formString(sb.toString(), A - 1);
    }

    private static int solve(int A, int B) {
        String str = formString("0", A);
        return Integer.parseInt(str.charAt(B - 1) + "");
    }

    public static void main(String[] args) {

    }
}
