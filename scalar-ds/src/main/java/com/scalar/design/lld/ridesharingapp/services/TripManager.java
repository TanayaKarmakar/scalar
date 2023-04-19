package com.scalar.design.lld.ridesharingapp.services;

import com.scalar.design.lld.ridesharingapp.models.Driver;
import com.scalar.design.lld.ridesharingapp.models.Location;
import com.scalar.design.lld.ridesharingapp.models.Rider;
import com.scalar.design.lld.ridesharingapp.models.Trip;
import com.scalar.design.lld.ridesharingapp.models.TripMetaData;
import com.scalar.design.lld.ridesharingapp.services.strategies.DriverMatchingStrategy;
import com.scalar.design.lld.ridesharingapp.services.strategies.PricingStrategy;
import com.scalar.design.lld.ridesharingapp.services.strategies.StrategyManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class TripManager {
  private static TripManager instance;
  private static Lock lock = new ReentrantLock();

  private Map<Integer, TripMetaData> tripMetaDataMap;
  private Map<Integer, Trip> tripMap;

  private DriverManager driverManager;
  private RiderManager riderManager;

  private TripManager() {
    this.tripMetaDataMap = new HashMap<>();
    this.tripMap = new HashMap<>();
    driverManager = DriverManager.getInstance();
    riderManager = RiderManager.getInstance();
  }

  public static TripManager getInstance() {
    if(instance == null) {
      lock.lock();
      if(instance == null) {
        instance = new TripManager();
      }
      lock.unlock();
    }
    return instance;
  }

  public void createTrip(Rider rider, Location source, Location destination) {
    TripMetaData tripMetaData = new TripMetaData(rider.getRating(), source, destination);
    StrategyManager strategyManager = StrategyManager.getInstance();
    PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetaData);
    DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineDriverMatchingStrategy(tripMetaData);

    Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
    double tripPrice = pricingStrategy.calculatePrice(tripMetaData);
    Trip trip = new Trip(rider, driver, source, destination, tripPrice, pricingStrategy, driverMatchingStrategy);
    int tripId = trip.getTripId();
    tripMap.put(tripId, trip);
    tripMetaDataMap.put(tripId, tripMetaData);
  }

  public Map<Integer, Trip> getTripMap() {
    return tripMap;
  }

}
