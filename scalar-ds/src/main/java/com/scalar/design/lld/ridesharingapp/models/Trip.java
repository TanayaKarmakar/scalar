package com.scalar.design.lld.ridesharingapp.models;

import com.scalar.design.lld.ridesharingapp.enums.TripStatus;
import com.scalar.design.lld.ridesharingapp.services.strategies.DriverMatchingStrategy;
import com.scalar.design.lld.ridesharingapp.services.strategies.PricingStrategy;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class Trip {
  private Rider rider;
  private Driver driver;
  private Location source;
  private Location destination;
  private TripStatus tripStatus;
  private int tripId;
  private double price;
  private PricingStrategy pricingStrategy;
  private DriverMatchingStrategy driverMatchingStrategy;

  private static int nextTripId = 1;


  public Trip(Rider rider, Driver driver, Location source,
              Location destination, double price,
              PricingStrategy pricingStrategy,
              DriverMatchingStrategy driverMatchingStrategy) {
    this.rider = rider;
    this.driver = driver;
    this.source = source;
    this.destination = destination;
    this.price = price;
    this.pricingStrategy = pricingStrategy;
    this.driverMatchingStrategy = driverMatchingStrategy;
    this.tripStatus = TripStatus.DRIVER_ON_THE_WAY;
    this.tripId = nextTripId++;
  }

  public int getTripId() {
    return tripId;
  }

  public String toString() {
    return "{ tripId: " + tripId + ","
        + "Rider: " + rider.getName() + ","
        + "Driver: " + driver.getName() + ","
        + "Price: " + price + ","
        + "Locations: { source: { latitude: " + source.getLatitude() + ", longitude: " + source.getLongitude() + "}," +
        "destination: { latitude: " + destination.getLatitude() + ", longitude: " + destination.getLongitude() + "}}}";
  }
}
