package com.scalar.design.lld.quadtree;

/**
 * @author t0k02w6 on 17/04/23
 * @project scalar-ds
 */
public class Location {
  private double x;
  private double y;

  public Location(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
