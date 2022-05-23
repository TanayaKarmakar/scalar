package com.scalar.twopointers.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 11/05/22
 * @project scalar
 */
public class ThreeSumZero {
    private static int[][] threeSum(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < (n - 2); i++) {
            int start = i + 1;
            int end = n - 1;
            while(start < end) {
                int sum = A[i] + A[start] + A[end];
                if(sum == 0) {
                    List<Integer> current = new ArrayList<>();
                    current.add(A[i]);
                    current.add(A[start]);
                    current.add(A[end]);
                    result.add(current);
                    start++;
                    end--;
                } else if(sum > 0)
                    end--;
                else
                    start++;
            }
        }
        List<List<Integer>> res = new ArrayList<>(result);
        int[][] finalResult = new int[result.size()][3];

        for(int i = 0; i < res.size(); i++) {
            int[] current = new int[3];
            current[0] = res.get(i).get(0);
            current[1] = res.get(i).get(1);
            current[2] = res.get(i).get(2);
            finalResult[i] = current;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,4};
        int[][] finalResult = threeSum(nums);

        for(int i = 0; i < finalResult.length; i++) {
            System.out.println(Arrays.toString(finalResult[i]));
        }
    }
}
