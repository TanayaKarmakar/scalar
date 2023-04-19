package com.scalar.design.lld.ridesharingapp.services.strategies;

import com.scalar.design.lld.ridesharingapp.models.TripMetaData;
import com.scalar.design.lld.ridesharingapp.services.strategies.impl.LeastTimeBasedMatchingStrategy;
import com.scalar.design.lld.ridesharingapp.services.strategies.impl.RatingBasedPricingStrategy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class StrategyManager {
  private static StrategyManager instance;
  private static Lock lock = new ReentrantLock();

  private StrategyManager() {

  }

  public static StrategyManager getInstance() {
    if(instance == null) {
      lock.lock();
      if(instance == null) {
        instance = new StrategyManager();
      }
      lock.unlock();
    }
    return instance;
  }

  public PricingStrategy determinePricingStrategy(TripMetaData tripMetaData) {
    System.out.println("Based on location and other factors, setting pricing strategy ");
    return new RatingBasedPricingStrategy();
  }

  public DriverMatchingStrategy determineDriverMatchingStrategy(TripMetaData tripMetaData) {
    System.out.println("Based on location and other factors, setting pricing strategy");
    return new LeastTimeBasedMatchingStrategy();
  }
}
