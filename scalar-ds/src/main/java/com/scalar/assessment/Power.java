package com.scalar.assessment;

/**
 * @author t0k02w6 on 19/12/21
 * @project scalar-ds
 */
public class Power {
    private static int pow(int A, int B, int C) {
        if(A == 0)
            return 0;
        if(B == 0)
            return 1;
        if(A < 0)
            A = A + C;
        int ans = (A * A) % C;
        if(B % 2 == 0)
            return pow(ans, B / 2, C);
        else
            return (A * pow(ans, (B - 1)/ 2, C)) % C;
    }

    public static void main(String[] args) {
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;

        int ans = pow(A, B, C);
        System.out.println(ans);
    }
}
