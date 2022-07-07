package com.scalar.ds.arrays;

import com.scalar.ds.common.QueryTriplet;

/**
 * @author t0k02w6 on 15/01/22
 * @project scalar-ds
 */

public class RangeQueryOddEven {
    private static int rangeQuery(int[] nums, QueryTriplet<Integer, Integer, String> query) {
        int n = nums.length;
        int[] psEven = new int[n];
        int[] psOdd = new int[n];

        psEven[0] = nums[0];
        psOdd[1] = nums[1];

        for(int i = 2; i < n; i++) {
            if(i % 2 == 0) {
                psEven[i] = psEven[i - 2] + nums[i];
                psOdd[i] = psOdd[i - 1];
            } else {
                psOdd[i] = psOdd[i - 2] + nums[i];
                psEven[i] = psEven[i - 1];
            }
        }

        int start = query.getFirst();
        int end = query.getSecond();
        String queryType = query.getThird();
        if(queryType.equals("E")) {
            if(start == 0)
                return psEven[end];
            return psEven[end] - psEven[start - 1];
        } else {
            if(start == 0)
                return psOdd[end];
            return psOdd[end] - psOdd[start - 1];
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,-1,0,8,5,4};
        QueryTriplet<Integer, Integer, String> query = new QueryTriplet<>(1,5, "E");

        int ans = rangeQuery(nums, query);

        System.out.println(ans);

    }
}
