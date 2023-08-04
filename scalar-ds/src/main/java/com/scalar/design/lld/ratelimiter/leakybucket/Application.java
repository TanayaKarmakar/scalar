package com.scalar.design.lld.ratelimiter.leakybucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class Application {
  public static void main(String[] args) {
    UserBucketCreator userBucketCreator = new UserBucketCreator(1);
    ExecutorService executors = Executors.newFixedThreadPool(12);
    for(int i = 0; i < 12; i++) {
      executors.submit(() -> userBucketCreator.accessApplication(1));
    }
    executors.shutdown();
  }
}
