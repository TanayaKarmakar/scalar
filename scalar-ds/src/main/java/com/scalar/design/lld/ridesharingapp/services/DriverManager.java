package com.scalar.design.lld.ridesharingapp.services;

import com.scalar.design.lld.ridesharingapp.models.Driver;
import com.scalar.design.lld.ridesharingapp.models.Rider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class DriverManager {
  private static DriverManager instance;
  private static Lock lock = new ReentrantLock();

  private Map<String, Driver> driverMap;

  private DriverManager() {
    this.driverMap = new HashMap<>();
  }

  public static DriverManager getInstance() {
    if(instance == null) {
      lock.lock();
      if(instance == null) {
        instance = new DriverManager();
      }
      lock.unlock();
    }
    return instance;
  }

  public void addDriver(String driverName, Driver driver) {
    this.driverMap.put(driverName, driver);
  }

  public Driver getDriver(String driverName) {
    return this.driverMap.get(driverName);
  }

  public Map<String, Driver> getDriverMap() {
    return driverMap;
  }
}
