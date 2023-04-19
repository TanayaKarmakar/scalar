package com.scalar.design.lld.ridesharingapp.models;

import com.scalar.design.lld.ridesharingapp.enums.Rating;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class Rider {
  private String name;
  private Rating rating;

  public Rider(String name, Rating rating) {
    this.name = name;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public Rating getRating() {
    return rating;
  }
}
