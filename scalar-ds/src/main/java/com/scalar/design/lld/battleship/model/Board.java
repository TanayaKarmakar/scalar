package com.scalar.design.lld.battleship.model;

import com.scalar.design.lld.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.scalar.design.lld.battleship.model.boundary.IBoundary;
import com.scalar.design.lld.battleship.model.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Board {
  private final List<BoardItem> ships;
  private final IBoundary boundary;
  private final List<Coordinate> allBombLocations;


  public Board(List<BoardItem> ships, IBoundary boundary) {
    this.ships = ships;
    this.boundary = boundary;
    this.allBombLocations = new ArrayList<>();
  }


  public void takeHit(Coordinate coordinate) {
    if(!boundary.contains(coordinate))
      throw new CoordinateOutOfBoundaryException();
    allBombLocations.add(coordinate);
  }

  public List<BoardItem> getShips() {
    return ships;
  }

  public IBoundary getBoundary() {
    return boundary;
  }

  public List<Coordinate> getAllBombLocations() {
    return allBombLocations;
  }

  public boolean areAllShipsKilled() {
    for(BoardItem ship: ships) {
      if(!ship.isKilled(allBombLocations))
        return false;
    }
    return true;
  }

  public List<Coordinate> hitLocations() {
    final List<Coordinate> result = new ArrayList<>();

    for(Coordinate coordinate: allBombLocations) {
      for(BoardItem ship: ships) {
        if(ship.containsCoordinate(coordinate)) {
          result.add(coordinate);
          break;
        }
      }
    }
    return result;
  }

  public List<Coordinate> missLocations() {
    final List<Coordinate> result = new ArrayList<>();

    for(Coordinate coordinate: allBombLocations) {
      boolean doesBelongToShip = false;

      for(BoardItem ship: ships) {
        if(ship.containsCoordinate(coordinate)) {
          doesBelongToShip = true;
          break;
        }
      }

      if(!doesBelongToShip) {
        result.add(coordinate);
      }
    }
    return result;
  }
}
