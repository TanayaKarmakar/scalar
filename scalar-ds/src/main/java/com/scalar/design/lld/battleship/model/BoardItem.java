package com.scalar.design.lld.battleship.model;

import com.scalar.design.lld.battleship.model.boundary.IBoundary;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class BoardItem {
  private final String name;
  private final IBoundary boundary;


  public BoardItem(String name, IBoundary boundary) {
    this.name = name;
    this.boundary = boundary;
  }

  public boolean isKilled(final List<Coordinate> hitLocations) {
    final List<Coordinate> shipCoordinates = boundary.allCoordinates();
    for(Coordinate shipCoordinate: shipCoordinates) {
      if(!hitLocations.contains(shipCoordinate))
        return false;
    }
    return true;
  }

  public boolean containsCoordinate(final Coordinate coordinate) {
    return this.boundary.contains(coordinate);
  }
}
