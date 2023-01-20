package com.scalar.design.lld.parkinglotv2.generators;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class ParkingSpotIDGenerator {
  private static AtomicLong idCounter = new AtomicLong();

  public static Long nextId() {
    return idCounter.getAndIncrement();
  }
}
