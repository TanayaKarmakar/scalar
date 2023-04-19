package com.scalar.design.lld.ridesharingapp;

import com.scalar.design.lld.ridesharingapp.enums.Rating;
import com.scalar.design.lld.ridesharingapp.models.Driver;
import com.scalar.design.lld.ridesharingapp.models.Location;
import com.scalar.design.lld.ridesharingapp.models.Rider;
import com.scalar.design.lld.ridesharingapp.models.Trip;
import com.scalar.design.lld.ridesharingapp.services.DriverManager;
import com.scalar.design.lld.ridesharingapp.services.RiderManager;
import com.scalar.design.lld.ridesharingapp.services.TripManager;
import java.util.Map;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class RideSharingAppTest {
  public static void main(String[] args) {
    Rider rider1 = new Rider("John", Rating.TWO);
    Rider rider2 = new Rider("Jenna", Rating.FOUR);

    RiderManager riderManager = RiderManager.getInstance();
    riderManager.addRider(rider1.getName(), rider1);
    riderManager.addRider(rider2.getName(), rider2);

    Driver driver1 = new Driver("Clement", Rating.THREE);
    Driver driver2 = new Driver("Jordan", Rating.FOUR);

    DriverManager driverManager = DriverManager.getInstance();
    driverManager.addDriver(driver1.getName(), driver1);
    driverManager.addDriver(driver2.getName(), driver2);

    TripManager tripManager = TripManager.getInstance();
    System.out.println("Creating trip for Rider: " + rider1.getName()
        + " from Location (10, 10) to Location(30,30)");
    tripManager.createTrip(rider1, new Location(10, 10), new Location(30, 30));


    System.out.println("Creating trip for Rider: " + rider2.getName() + " from Location(200, 200) " +
        "to Location(500,500)");
    tripManager.createTrip(rider2, new Location(200, 200), new Location(500, 500));

    Map<Integer, Trip> tripMap = tripManager.getTripMap();
    for(Map.Entry<Integer, Trip> entry: tripMap.entrySet()) {
      System.out.println(entry.getValue());
    }

  }
}
