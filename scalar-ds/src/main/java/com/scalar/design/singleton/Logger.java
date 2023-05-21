package com.scalar.design.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 20/05/23
 * @project scalar-ds
 */
public class Logger {
  private static Logger instance;
  private static Lock lock = new ReentrantLock();

  private Logger() {
    System.out.println("New Instance Created");
  }

  public static Logger getInstance() {
    if(instance == null) {
      lock.lock();
      if(instance == null) {
        instance = new Logger();
      }
      lock.unlock();
    }
    return instance;
  }
}
