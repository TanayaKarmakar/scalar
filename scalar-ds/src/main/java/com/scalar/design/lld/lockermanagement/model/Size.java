package com.scalar.design.lld.lockermanagement.model;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Size {
  private final Double width;
  private final Double height;

  public Size(Double width, Double height) {
    this.width = width;
    this.height = height;
  }

  public Double getWidth() {
    return width;
  }

  public Double getHeight() {
    return height;
  }

  public boolean canAccommodate(Size sizeToAccommodate) {
    return this.width >= sizeToAccommodate.width
        && this.height >= sizeToAccommodate.height;
  }
}
