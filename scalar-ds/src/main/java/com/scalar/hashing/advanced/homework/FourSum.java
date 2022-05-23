package com.scalar.hashing.advanced.homework;

import java.util.*;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
public class FourSum {
    private static int[][] fourSum(int[] A, int B) {
        Arrays.sort(A);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int k = j + 1;
                int l = A.length - 1;

                while (k < l) {
                    int sum = A[i] + A[j] + A[k] + A[l];

                    if (sum > B) {
                        l--;
                    } else if (sum < B) {
                        k++;
                    } else if (sum == B) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(A[i]);
                        temp.add(A[j]);
                        temp.add(A[k]);
                        temp.add(A[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        int[][] finalResult = new int[result.size()][4];
        int i = 0;
        for(ArrayList<Integer> res: result) {
            int[] curr = new int[4];
            curr[0] = res.get(0);
            curr[1] = res.get(1);
            curr[2] = res.get(2);
            curr[3] = res.get(3);
            finalResult[i++] = curr;

        }

        return finalResult;
    }

    public static void main(String[] args) {

    }
}
