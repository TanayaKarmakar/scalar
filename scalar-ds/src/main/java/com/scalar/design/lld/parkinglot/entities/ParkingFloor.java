package com.scalar.design.lld.parkinglot.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingFloor {
  private int floorNumber;
  private Map<VehicleType, List<ParkingSpot>> parkingSpots;
  private Map<VehicleType, Integer> emptySpots;

  public int getFloorNumber() {
    return floorNumber;
  }

  public void setFloorNumber(int floorNumber) {
    this.floorNumber = floorNumber;
  }

  public Map<VehicleType, List<ParkingSpot>> getParkingSpots() {
    return parkingSpots;
  }

  public int getFirstFreeSpot(VehicleType vehicleType) {
    List<ParkingSpot> spots = parkingSpots.get(vehicleType);
    for(ParkingSpot spot: spots) {
      if(!spot.isOccupied())
        return spot.getParkingSpotNumber();
    }
    return -1;
  }

  public boolean park(Vehicle vehicle) {
    int spotNumber = getFirstFreeSpot(vehicle.getVehicleType());
    if(spotNumber == -1) {
      System.out.println("No empty spot for " + vehicle.getVehicleType());
      return false;
    }
    ParkingSpot spot = parkingSpots.get(vehicle.getVehicleType()).get(spotNumber);
    return spot.park(vehicle);
  }

  public void setParkingSpots(
      Map<VehicleType, List<ParkingSpot>> parkingSpots) {
    this.parkingSpots = parkingSpots;
  }

  private void calcEmptySpots() {
    parkingSpots.entrySet().forEach(vehicleType -> {
      int emptySpots = 0;
      for(ParkingSpot spot: vehicleType.getValue()) {
        if(!spot.isOccupied()) {
          emptySpots++;
        }
      }
      this.emptySpots.put(vehicleType.getKey(), emptySpots);
    });
  }

  public void printStatus() {
    System.out.println("Floor: " + floorNumber + ": EMPTY SpotS");
    parkingSpots.entrySet().forEach(vehicleType -> {

    });
  }

  public static class Builder {
    Integer number;
    Map<VehicleType, Integer> SpotCapacity;

    public Builder() {
      this.SpotCapacity = new HashMap<>();
    }

    public Builder(int number) {
      this.number = number;
      this.SpotCapacity = new HashMap<>();
    }

    public Builder setNumber(int number) {
      this.number = number;
      return this;
    }

    public Builder addSpots(VehicleType type, int capacity) {
      this.SpotCapacity.put(type, capacity);
      return this;
    }

    public ParkingFloor build() {
      if(number == null) {
        throw new IllegalStateException("Floor number is not set");
      }
      Map<VehicleType, List<ParkingSpot>> parkingSpots = new HashMap<>();
      Map<VehicleType, Integer> emptySpots = new HashMap<>();

      for(Map.Entry<VehicleType, Integer> entry: SpotCapacity.entrySet()) {
        parkingSpots.put(entry.getKey(), ParkingSpot.createSpots(entry.getKey(), entry.getValue()));
        emptySpots.put(entry.getKey(), entry.getValue());
      }
      ParkingFloor floor = new ParkingFloor();
      floor.floorNumber = number;
      floor.parkingSpots = parkingSpots;
      floor.emptySpots = emptySpots;

      return floor;
    }
  }
}
