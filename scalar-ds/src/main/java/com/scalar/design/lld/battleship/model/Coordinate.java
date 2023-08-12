package com.scalar.design.lld.battleship.model;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Coordinate {
  private final int x;
  private final int y;

  public Coordinate(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return "Coordinate{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
