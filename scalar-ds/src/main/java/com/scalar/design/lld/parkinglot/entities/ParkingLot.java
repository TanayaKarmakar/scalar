package com.scalar.design.lld.parkinglot.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingLot {
  private List<ParkingFloor> floors;
  private Map<VehicleType, Integer> parkingFees;

  public List<ParkingFloor> getFloors() {
    return floors;
  }

  public void setFloors(List<ParkingFloor> floors) {
    this.floors = floors;
  }

  public Map<VehicleType, Integer> getParkingFees() {
    return parkingFees;
  }

  public void setParkingFees(
      Map<VehicleType, Integer> parkingFees) {
    this.parkingFees = parkingFees;
  }

  public static class Builder {
    private int numFloors;
    private List<ParkingFloor> floors;
    private Map<VehicleType, Integer> parkingFees;

    public Builder() {
      this.floors = new ArrayList<>();
      this.parkingFees = new HashMap<>();
    }

    public Builder(int numFloors) {
      this.numFloors = numFloors;
      this.floors = new ArrayList<>();
      this.parkingFees = new HashMap<>();
    }

    public Builder setParkingFees(VehicleType type, int fee) {
      this.parkingFees.put(type, fee);
      return this;
    }

    public Builder addFloor(ParkingFloor floor) {
      if(floors.size() == numFloors) {
        System.out.println("Cannot add more floors");
        return this;
      }
      floors.add(floor);
      return this;
    }

    public ParkingLot build() {
      if(floors.size() < numFloors) {
        throw new IllegalStateException("All floors are not defined");
      }
      ParkingLot parkingLot = new ParkingLot();
      parkingLot.floors = floors;
      parkingLot.parkingFees = parkingFees;
      return parkingLot;
    }
  }
}
