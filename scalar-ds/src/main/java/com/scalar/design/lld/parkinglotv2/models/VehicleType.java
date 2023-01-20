package com.scalar.design.lld.parkinglotv2.models;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
public enum VehicleType {
  BIKE, CAR, TRUCK;

  public SpotType toSpotType() {
    switch (this) {
      case BIKE:
        return SpotType.SMALL;
      case CAR:
        return SpotType.MEDIUM;
      case TRUCK:
        return SpotType.LARGE;
    }
    throw new RuntimeException("Invalid Vehicle Type" + this);
  }
}
