package com.scalar.design.lld.ridesharingapp.models;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class Location {
  private double latitude;
  private double longitude;

  public Location(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }
}
