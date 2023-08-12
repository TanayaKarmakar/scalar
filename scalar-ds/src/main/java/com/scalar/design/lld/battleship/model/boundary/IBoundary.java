package com.scalar.design.lld.battleship.model.boundary;

import com.scalar.design.lld.battleship.model.Coordinate;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface IBoundary {
  List<Coordinate> allCoordinates();
  boolean contains(Coordinate coordinate);
}
