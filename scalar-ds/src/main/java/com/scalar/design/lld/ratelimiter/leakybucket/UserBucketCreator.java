package com.scalar.design.lld.ratelimiter.leakybucket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class UserBucketCreator {
  Map<Integer, LeakyBucket> bucket;

  public UserBucketCreator(int id) {
    bucket = new HashMap<>();
    bucket.put(id, new LeakyBucket(10));
  }

  public void accessApplication(int id) {
    if(bucket.get(id).grantAccess()) {
      System.out.println(Thread.currentThread().getName() + " -> able to access the application");
    } else {
      System.out.println(Thread.currentThread().getName() + " -> Too many requests, please try after sometime ");
    }
  }
}
