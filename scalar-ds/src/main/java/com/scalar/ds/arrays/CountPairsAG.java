package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class CountPairsAG {
    private static int countPairs(String str) {
        char[] arr = str.toCharArray();

        int count = 0;
        int ans = 0;
        for(int i = 0; i < arr.length;i++) {
            if(arr[i] == 'a')
                count++;
            else if(arr[i] == 'g')
                ans += count;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "bcaggaag";

        int ans = countPairs(str);

        System.out.println(ans);
    }
}
