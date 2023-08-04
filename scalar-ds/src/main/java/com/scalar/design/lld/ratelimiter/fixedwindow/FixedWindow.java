package com.scalar.design.lld.ratelimiter.fixedwindow;

import com.scalar.design.lld.ratelimiter.RateLimiter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author t0k02w6 on 03/08/23
 * @project scalar-ds
 */
public class FixedWindow implements RateLimiter {
  private long windowSize;
  private int maxAllowedRequest;
  private ConcurrentMap<Long, Integer> bucketMap;

  public FixedWindow(long windowSize, int maxAllowedRequest) {
    this.windowSize = windowSize;
    this.maxAllowedRequest = maxAllowedRequest;
    this.bucketMap = new ConcurrentHashMap<>();
  }

  @Override
  public boolean grantAccess() {
    long currentTime = System.currentTimeMillis() / 1000;
    long bucket = currentTime / windowSize;

    if(!bucketMap.containsKey(bucket) || bucketMap.get(bucket) < maxAllowedRequest) {
      bucketMap.put(bucket, bucketMap.getOrDefault(bucket, 0) + 1);
      return true;
    } else {
      return false;
    }
  }
}
