package com.scalar.design.hld.ratelimiter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 03/04/23
 * @project scalar-ds
 */
public class Solution {
  private static final int interval = 10;
  private static final int maxReq = 3;


  private static int[] solve(int[] A, int[] B) {
    int n = A.length;
    int[] result = new int[n];
    Map<Integer, Queue<Integer>> requestMap = new HashMap<>();
    for(int i = 0; i < n; i++) {
      if(!requestMap.containsKey(A[i])) {
        requestMap.put(A[i], new LinkedList<>());
        requestMap.get(A[i]).add(B[i]);
        result[i] = 1;
      } else {
        Queue<Integer> q = requestMap.get(A[i]);
        int currentTimeStamp = B[i];
        while(!q.isEmpty() && q.peek() <= (currentTimeStamp - interval)) {
          q.poll();
        }
        if(q.size() < maxReq) {
          result[i] = 1;
          q.add(B[i]);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 1, 2, 1, 1, 1};
    int[] B = new int[] {1, 2, 2, 9, 10, 11};

    int[] result = solve(A, B);

    System.out.println(Arrays.toString(result));
  }
}
