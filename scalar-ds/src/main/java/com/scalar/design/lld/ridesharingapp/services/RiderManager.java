package com.scalar.design.lld.ridesharingapp.services;

import com.scalar.design.lld.ridesharingapp.models.Rider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class RiderManager {
  private static RiderManager instance;
  private static Lock lock = new ReentrantLock();

  private Map<String, Rider> riderMap;

  private RiderManager() {
    this.riderMap = new HashMap<>();
  }

  public static RiderManager getInstance() {
    if(instance == null) {
      lock.lock();
      if(instance == null) {
        instance = new RiderManager();
      }
      lock.unlock();
    }
    return instance;
  }


  public void addRider(String riderName, Rider rider) {
    this.riderMap.put(riderName, rider);
  }

  public Rider getRider(String riderName) {
    return this.riderMap.get(riderName);
  }
}
