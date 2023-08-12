package com.scalar.design.lld.battleship.model.boundary;

import com.scalar.design.lld.battleship.model.Coordinate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class RectangularBoundary implements IBoundary {
  private final Coordinate topLeft;
  private final Coordinate bottomRight;

  public RectangularBoundary(Coordinate topLeft, Coordinate bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }


  @Override
  public List<Coordinate> allCoordinates() {
    List<Coordinate> coordinates = new ArrayList<>();
    for(int i = topLeft.getX(); i <= bottomRight.getX(); i++) {
      for(int j = topLeft.getY(); j <= bottomRight.getY(); j++) {
        coordinates.add(new Coordinate(i, j));
      }
    }
    return coordinates;
  }

  @Override
  public boolean contains(Coordinate coordinate) {
    return coordinate.getX() >= topLeft.getX() && coordinate.getY() <= bottomRight.getX()
        && coordinate.getY() >= topLeft.getY() && coordinate.getY() <= bottomRight.getY();
  }
}
