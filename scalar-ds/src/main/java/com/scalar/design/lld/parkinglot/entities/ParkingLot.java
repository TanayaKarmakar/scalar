package com.scalar.design.lld.parkinglot.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingLot {
  private List<ParkingFloor> floors;

  public static class Builder {
    private int numFloors;
    private List<ParkingFloor> floors;

    public Builder() {
      this.floors = new ArrayList<>();
    }

    public Builder(int numFloors) {
      this.numFloors = numFloors;
      this.floors = new ArrayList<>();
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
      return parkingLot;
    }
  }
}
