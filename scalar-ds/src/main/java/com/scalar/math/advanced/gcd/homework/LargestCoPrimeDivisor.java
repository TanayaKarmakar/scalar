package com.scalar.math.advanced.gcd.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 08/04/22
 * @project scalar
 */
public class LargestCoPrimeDivisor {
    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static int cpFact(int A, int B) {
        List<Integer> factors = new ArrayList<>();
        int n = (int)Math.sqrt(A);
        int k = 0;
        for(int i = 1; i <= n; i++) {
            if(A % i == 0) {
                if(i == A/i) {
                    factors.add(k, i);
                } else {
                    factors.add(k, i);
                    factors.add(k + 1, A/i);
                }
                k++;
            }
        }
        int i = 0;
        int ans = 0;
        while(i < factors.size()) {
            int gcd = gcd(B, factors.get(i));
            if(gcd == 1)
                ans = factors.get(i);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 12;
        System.out.println(cpFact(A, B));
    }
}
