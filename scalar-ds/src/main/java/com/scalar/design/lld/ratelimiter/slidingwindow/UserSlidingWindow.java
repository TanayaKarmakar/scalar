package com.scalar.design.lld.ratelimiter.slidingwindow;

import com.scalar.design.lld.ratelimiter.slidingwindow.SlidingWindow;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class UserSlidingWindow {
  Map<Integer, SlidingWindow> bucket;

  public UserSlidingWindow(int id) {
    bucket = new HashMap<>();
    bucket.put(id, new SlidingWindow(1, 10));
  }

  void accessApplication(int id) {
    if(bucket.get(id).grantAccess()) {
      System.out.println("Able to access");
    } else {
      System.out.println("Too many requests");
    }
  }
}
