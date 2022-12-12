package com.scalar.design.lld.parkinglot.entities;

import java.util.Date;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingTicket {
  private Date startTime;
  private Date endTime;
  private Vehicle vehicle;
  private ParkingSpot spot;
  private ParkingLot parkingLot;

  public int endParking(Date endTime) {
    this.endTime = endTime;

    long diff = endTime.getTime() - startTime.getTime();
    long diffMinutes = diff / (60 * 1000) % 60;
    int diffHours = Math.toIntExact(diff / (60 * 60 * 1000) % 24);
    var fees = this.parkingLot.getParkingFees().get(vehicle.getVehicleType());
    return fees * diffHours;
  }


}
