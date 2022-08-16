package com.scalar.ds.revision.bitmanipulation.homework;

/**
 * @author t0k02w6 on 12/08/22
 * @project scalar
 */


/**
 * (A + B) = (A ^ B) + 2 * (A & B)
 * if (A + B) == (A ^ B) then (A & B) == 0
 */
public class StrangeEquality {
    private static int solve(int A) {
        int setBitPos = 0;

        for(int i = 0; i < 31; i++) {
            int mask = (1 << i);
            if((A & mask) > 0) {
                setBitPos = i;
            }
        }

        int x = 0;
        if((A & (A - 1)) == 0) {
            x = A - 1;
        } else {
            for(int i = 0; i <= setBitPos; i++) {
                int mask = (1 << i);
                if((A & mask) == 0) {
                    x = x + (1 << i);
                }
            }
        }


        int y = (1 << (setBitPos + 1));
        return x ^ y;
    }

    public static void main(String[] args) {
        int x = 5;
        int ans = solve(x);

        System.out.println(ans);
    }
}
