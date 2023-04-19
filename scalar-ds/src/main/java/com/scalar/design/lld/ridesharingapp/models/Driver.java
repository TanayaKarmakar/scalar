package com.scalar.design.lld.ridesharingapp.models;

import com.scalar.design.lld.ridesharingapp.enums.Rating;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class Driver {
  private String name;
  private boolean isAvailable;
  private Rating rating;

  public Driver(String name,Rating rating) {
    this.name = name;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public Rating getRating() {
    return rating;
  }
}
