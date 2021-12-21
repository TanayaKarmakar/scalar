package com.scalar.strings;

/**
 * @author t0k02w6 on 20/12/21
 * @project scalar-ds
 */
public class SplitStrings {
    private static int solve(String A) {
        if(A == null || A.isEmpty())
            return 0;
        int c = 0; int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0')
                c--;
            else
                c++;
            if(c == 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "011100";

        int count = solve(s);

        System.out.println(count);

        s = "00011011";

        count = solve(s);

        System.out.println(count);
    }
}
