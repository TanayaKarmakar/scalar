package com.scalar.design.lld.parkinglot.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingSpot {
  private int parkingSpotNumber;
  private VehicleType type;
  private Vehicle vehicle;


  public boolean isOccupied() {
    return Objects.nonNull(vehicle);
  }

  public boolean park(Vehicle vehicle) {
    if(isOccupied()) {
      System.out.println("Parking spot is occupied");
      return false;
    }

    if(vehicle.getVehicleType() != type) {
      System.out.println("Vehicle type does not match with the parking spot type");
      return false;
    }
    this.vehicle = vehicle;
    return true;
  }

  public static List<ParkingSpot> createSpots(VehicleType type, int capacity) {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    for(int i = 0; i < capacity; i++) {
      ParkingSpot spot = new ParkingSpot();
      spot.setParkingSpotNumber(i);
      spot.setType(type);
      parkingSpots.add(spot);
    }
    return parkingSpots;
  }

  public int getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  public void setParkingSpotNumber(int parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
