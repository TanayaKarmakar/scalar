package com.scalar.design.lld.ratelimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class SlidingWindow implements RateLimiter {
  private Queue<Integer> slidingWindow;
  private int bucketCap;
  private int time;

  public SlidingWindow(int time, int cap) {
    this.time = time;
    this.bucketCap = cap;
    this.slidingWindow = new ConcurrentLinkedQueue<>();
  }

  @Override
  public boolean grantAccess() {
    long currentTime = System.currentTimeMillis();
    updateQueue(currentTime);
    if(slidingWindow.size() < bucketCap) {
      slidingWindow.offer((int)currentTime);
      return true;
    }
    return false;
  }

  private void updateQueue(long currentTime) {
    if(slidingWindow.isEmpty())
      return;
    long time = (currentTime - slidingWindow.peek()) / 1000;
    while(time >= this.time) {
      slidingWindow.poll();
      if(slidingWindow.isEmpty())
        break;
      time = (currentTime - slidingWindow.peek()) / 1000;
    }
  }
}
