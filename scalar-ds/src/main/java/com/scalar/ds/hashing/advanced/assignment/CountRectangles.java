package com.scalar.ds.hashing.advanced.assignment;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 10/05/23
 * @project scalar-ds
 */
public class CountRectangles {
  private static int solve(int[] A, int[] B) {
    Set<String> pointSets = new HashSet<>();

    int n = A.length;
    for(int i = 0; i < n; i++) {
      int x = A[i];
      int y = B[i];

      pointSets.add(x + ":" + y);
    }

    int count = 0;
    for(int i = 0; i < (n - 1); i++) {
      for(int j = i + 1; j < n; j++) {
        if(A[i] != A[j] && B[i] != B[j]) {
          String p3 = A[i] + ":" + B[j];
          String p4 = A[j] + ":" + B[i];

          if(pointSets.contains(p3) && pointSets.contains(p4)) {
            count++;
          }
        }
      }
    }
    return count / 2;
  }

  public static void main(String[] args) {
    int[] A = {1,1,2,2};
    int[] B = {1,2,1,2};

    int ans = solve(A, B);
    System.out.println(ans);
  }
}
