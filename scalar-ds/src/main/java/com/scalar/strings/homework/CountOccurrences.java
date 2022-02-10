package com.scalar.strings.homework;

/**
 * @author t0k02w6 on 10/02/22
 * @project scalar
 */
public class CountOccurrences {
    private static int solve(String A) {
        int n = A.length();
        int i = 0;
        int count = 0;
        while(i < (n - 2)) {
            int j = i + 3;
            String str = A.substring(i, j);
            if(str.equals("bob")) {
                count++;
                i = j - 1;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abobc";

        int ans = solve(str);

        System.out.println(ans);
    }
}
