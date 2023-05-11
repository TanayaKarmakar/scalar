package com.scalar.ds.hashing.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/05/23
 * @project scalar-ds
 */
public class CountRightTriangles {
  private static int solve(int[] A, int[] B) {
    Map<Integer, Integer> pointXMap = new HashMap<>();
    Map<Integer, Integer> pointYMap = new HashMap<>();

    int n = A.length;
    for(int i = 0; i < n; i++) {
      pointXMap.put(A[i], pointXMap.getOrDefault(A[i], 0) + 1);
      pointYMap.put(B[i], pointYMap.getOrDefault(B[i], 0) + 1);
    }

    int ans = 0;
    int modulo = 1000000007;
    for(int i = 0; i < n; i++) {
      int a = pointXMap.get(A[i]);
      int b = pointYMap.get(B[i]);
      ans = ans + ((a - 1) * (b - 1)) % modulo;
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] A = {1,1,2,3,3};
    int[] B = {1, 2, 1, 2, 1};

    int ans = solve(A, B);

    System.out.println(ans);
  }
}
