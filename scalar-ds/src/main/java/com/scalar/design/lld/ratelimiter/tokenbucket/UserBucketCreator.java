package com.scalar.design.lld.ratelimiter.tokenbucket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class UserBucketCreator {
  Map<Integer, TokenBucket> bucket;

  public UserBucketCreator(int id) {
    bucket = new HashMap<>();
    bucket.put(id, new TokenBucket(10, 10));
  }

  void accessApplication(int id) {
    if(bucket.get(id).grantAccess()) {
      System.out.println(Thread.currentThread().getName() + " -> is able to access the application");
    } else {
      System.out.println(Thread.currentThread().getName() + " -> Too much request, please try after sometimes");
    }
  }

}
