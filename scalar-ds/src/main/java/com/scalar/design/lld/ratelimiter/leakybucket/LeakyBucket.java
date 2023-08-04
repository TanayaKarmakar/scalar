package com.scalar.design.lld.ratelimiter.leakybucket;

import com.scalar.design.lld.ratelimiter.RateLimiter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class LeakyBucket implements RateLimiter {
  private BlockingDeque<Integer> queue;

  public LeakyBucket(int capacity) {
    this.queue = new LinkedBlockingDeque<>(capacity);
  }

  @Override
  public boolean grantAccess() {
    if(queue.remainingCapacity() > 0) {
      queue.add(1);
      return true;
    }
    return false;
  }
}
