package com.scalar.design.lld.ridesharingapp.models;

import com.scalar.design.lld.ridesharingapp.enums.Rating;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class TripMetaData {
  private Rating riderRating;
  private Rating driverRating;
  private Location source;
  private Location destination;

  public TripMetaData(Rating riderRating,
                      Location source, Location destination) {
    this.riderRating = riderRating;
    this.source = source;
    this.destination = destination;
  }

  public Rating getRiderRating() {
    return riderRating;
  }

  public Rating getDriverRating() {
    return driverRating;
  }

  public void setDriverRating(Rating driverRating) {
    this.driverRating = driverRating;
  }

  public Location getSource() {
    return source;
  }

  public Location getDestination() {
    return destination;
  }
}
