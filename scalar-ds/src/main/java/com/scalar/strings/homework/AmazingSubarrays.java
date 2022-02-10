package com.scalar.strings.homework;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class AmazingSubarrays {
    private static boolean isVowel(char ch) {
        return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
        || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    private static int solve(String A) {
        int n = A.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(isVowel(A.charAt(i))) {
                count += (n - i);
            }
        }
        return count % 10003;
    }

    public static void main(String[] args) {
        String str = "ABEC";

        int ans = solve(str);

        System.out.println(ans);
    }
}
