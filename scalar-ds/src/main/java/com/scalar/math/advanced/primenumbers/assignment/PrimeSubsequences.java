package com.scalar.math.advanced.primenumbers.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class PrimeSubsequences {
    private static final int MOD = 1000000007;

    private static long pow(long a, long b, long m) {
        if(b == 0)
            return 1;
        long ans = (a * a) % MOD;
        if(b % 2 == 0)
            return pow(ans, b / 2, m);
        else
            return (a * pow(ans, (b - 1) / 2, m)) % m;
    }

    private static int solve(int[] A) {
        int max = Integer.MIN_VALUE;

        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            max = Integer.max(A[i], max);
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= max; i++) {
            int j = i;
            if(isPrime[i]) {
                while(i * j <= max) {
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }

        int count = 0;
        for(int i = 2; i <= max; i++) {
            if(isPrime[i] && map.containsKey(i)) {
                count += map.get(i);
            }
        }
        return (int)pow(2, count, MOD);
    }

    private static int pow(int i, int count) {
        if(count == 0)
            return 1;
        int smallValue = pow(i, count / 2);
        if(count % 2 == 0)
            return ((smallValue % MOD) * (smallValue % MOD)) % MOD;
        else
            return (((i * (smallValue % MOD)) % MOD) * (smallValue  % MOD)) % MOD;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        int ans = solve(nums);

        System.out.println(ans);


    }
}
