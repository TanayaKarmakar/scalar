package com.scalar.design.lld.ratelimiter.tokenbucket;

import com.scalar.design.lld.ratelimiter.RateLimiter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class TokenBucket implements RateLimiter {
  private int bucketCapacity;
  private int refreshRate;
  private AtomicInteger currentCapacity;
  private AtomicLong lastUpdatedTime;

  public TokenBucket(int bucketCapacity, int refreshRate) {
    this.bucketCapacity = bucketCapacity;
    this.refreshRate = refreshRate;
    currentCapacity = new AtomicInteger();
    lastUpdatedTime = new AtomicLong();
    currentCapacity.getAndSet(bucketCapacity);
    lastUpdatedTime.getAndSet(System.currentTimeMillis());
  }


  @Override
  public boolean grantAccess() {
    refreshBucket();
    if(currentCapacity.get() > 0) {
      currentCapacity.decrementAndGet();
      return true;
    }
    return false;
  }

  private void refreshBucket() {
    long currentTime = System.currentTimeMillis();
    int additionalToken = (int)((currentTime - lastUpdatedTime.get())/1000) * refreshRate;
    int currCapacity = Integer.min(currentCapacity.get() + additionalToken, bucketCapacity);
    currentCapacity.getAndSet(currCapacity);
    lastUpdatedTime.getAndSet(currentTime);
  }
}
