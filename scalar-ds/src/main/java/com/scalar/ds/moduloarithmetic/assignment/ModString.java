package com.scalar.ds.moduloarithmetic.assignment;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class ModString {
    private static int findMod(String A, int B) {
        int num = 0;
        int MOD = 1000000007;
        for(int i = 0; i < A.length(); i++) {
            num = ((num % B) * 10) % B;
            num = ((num % B) + (Integer.parseInt(A.charAt(i) + "") % B)) % B;
        }
        return num % B;
    }

    public static void main(String[] args) {
        String str = "43535321";
        int B = 47;

        int ans = findMod(str, B);

        System.out.println(ans);
    }
}
