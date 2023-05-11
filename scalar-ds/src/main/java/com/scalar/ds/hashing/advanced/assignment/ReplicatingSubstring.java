package com.scalar.ds.hashing.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 11/05/23
 * @project scalar-ds
 */
public class ReplicatingSubstring {
  private static int solve(int A, String B) {
    Map<Character, Integer> map = new HashMap<>();

    for(int i = 0; i < B.length(); i++) {
      char ch = B.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for(Map.Entry<Character, Integer> entry: map.entrySet()) {
      if(entry.getValue() % A != 0)
        return -1;
    }
    return 1;
  }

  public static void main(String[] args) {

  }
}
