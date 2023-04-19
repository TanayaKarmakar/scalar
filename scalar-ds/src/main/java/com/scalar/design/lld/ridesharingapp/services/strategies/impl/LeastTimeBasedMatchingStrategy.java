package com.scalar.design.lld.ridesharingapp.services.strategies.impl;

import com.scalar.design.lld.ridesharingapp.models.Driver;
import com.scalar.design.lld.ridesharingapp.models.TripMetaData;
import com.scalar.design.lld.ridesharingapp.services.DriverManager;
import com.scalar.design.lld.ridesharingapp.services.strategies.DriverMatchingStrategy;
import java.util.Iterator;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
  @Override
  public Driver matchDriver(TripMetaData tripMetaData) {
    DriverManager driverManager = DriverManager.getInstance();
    if(driverManager.getDriverMap().size() == 0) {
      System.out.println("There is no driver !!!!!!");
    }
    Iterator<String> drivers = driverManager.getDriverMap().keySet().iterator();

    Driver driver = driverManager.getDriverMap().get(drivers.next());
    System.out.println("Setting driver " + driver.getName() + " as driver");
    tripMetaData.setDriverRating(driver.getRating());
    return driver;
  }
}
