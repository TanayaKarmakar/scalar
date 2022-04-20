package com.scalar.arrays.advanced.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class MaxChunksToMakeSorted {
    private static int solve(int[] A) {
        int n = A.length;

        int startIndx = -1;
        int endIndx = -1;
        List<int[]> list = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            if(A[i] > A[i - 1]) {
                if(startIndx == -1) {
                    startIndx = (i - 1);
                    endIndx = (i - 1);
                } else {
                    endIndx = i;
                }
            } else {
                //if(startIndx != -1) {
                    startIndx = (i - 1);
                    endIndx = (i - 1);
                    list.add(new int[]{startIndx, endIndx});
                    startIndx = -1;
                    endIndx = -1;
                //}
            }
        }
        if(startIndx != -1 && (list.isEmpty() || (list.get(list.size() - 1)[0] != startIndx && list.get(list.size() - 1)[1] != endIndx))) {
            list.add(new int[]{startIndx, endIndx});
        }

        //System.out.println(list);

        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,3};

        int ans = solve(nums);

        System.out.println(ans);

        nums = new int[] {1,2,3,4,0};

        ans = solve(nums);

        System.out.println(ans);
    }
}
