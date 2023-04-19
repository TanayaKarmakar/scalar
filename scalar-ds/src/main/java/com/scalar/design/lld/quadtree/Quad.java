package com.scalar.design.lld.quadtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 17/04/23
 * @project scalar-ds
 */
public class Quad {
  private Location center;
  private double halfWidth;
  private double halfHeight;
  private QuadStatus quadStatus;
  private Cab cab;
  private Location cabLocation;
  private Quad nwChild;
  private Quad neChild;
  private Quad swChild;
  private Quad seChild;
  private Quad parent;
  private int quadId;

  public static int nextQuadId = 1;

  public Quad(Location center, double halfWidth, double halfHeight, Quad parent) {
    this.center = center;
    this.halfWidth = halfWidth;
    this.halfHeight = halfHeight;
    this.quadStatus = QuadStatus.EMPTY_LEAF;
    this.cab = null;
    this.cabLocation = null;
    this.nwChild = null;
    this.neChild = null;
    this.swChild = null;
    this.seChild = null;
    this.parent = parent;
    this.quadId = nextQuadId;
    nextQuadId++;
  }

  public void insert(Cab cab, Location location) {
    if(cab == null)
      return;
    if(!containsLocation(location)) {
      System.out.println("The location {" + location.getX() +","+location.getY() + "} at which you are trying to insert a cab is outside the boundary");
      return;
    }
    if(quadStatus == QuadStatus.EMPTY_LEAF) {
      this.cab = cab;
      this.cabLocation = location;
      System.out.println("Inserting cab at {" + location.getX() +"," + location.getY() + "} in quad with centre at " +
          "{" + center.getX() + "," + center.getY() + "}. Halfwidth, Halfheight values are " + halfWidth +"," + halfHeight);
      this.quadStatus = QuadStatus.FILLED_LEAF;
    }
    else if(quadStatus == QuadStatus.FILLED_LEAF) {
      this.quadStatus = QuadStatus.DIVIDED_NODE;
      createChildren();

      Quad parentQuad = this;
      Quad smallestQuadConsidered = this;
      SubQuad cabSubQuad = locateSubQuad(cabLocation);
      SubQuad newCabSubSquad = locateSubQuad(location);

      while(cabSubQuad == newCabSubSquad) {
        System.out.println("Since two cabs are in same sub squad hence dividing");
        parentQuad = smallestQuadConsidered;
        if(cabSubQuad == SubQuad.NORTH_WEST) {
          smallestQuadConsidered.nwChild.createChildren();
          cabSubQuad = smallestQuadConsidered.nwChild.locateSubQuad(cabLocation);
          newCabSubSquad = smallestQuadConsidered.nwChild.locateSubQuad(location);
          smallestQuadConsidered = smallestQuadConsidered.nwChild;
        } else if(cabSubQuad == SubQuad.NORTH_EAST) {
          smallestQuadConsidered.neChild.createChildren();
          cabSubQuad = smallestQuadConsidered.neChild.locateSubQuad(cabLocation);
          newCabSubSquad = smallestQuadConsidered.neChild.locateSubQuad(location);
          smallestQuadConsidered = smallestQuadConsidered.neChild;
        } else if(cabSubQuad == SubQuad.SOUTH_WEST) {
          smallestQuadConsidered.swChild.createChildren();
          cabSubQuad = smallestQuadConsidered.swChild.locateSubQuad(cabLocation);
          newCabSubSquad = smallestQuadConsidered.swChild.locateSubQuad(location);
          smallestQuadConsidered = smallestQuadConsidered.swChild;
        } else {
          smallestQuadConsidered.seChild.createChildren();
          cabSubQuad = smallestQuadConsidered.seChild.locateSubQuad(cabLocation);
          newCabSubSquad = smallestQuadConsidered.seChild.locateSubQuad(location);
          smallestQuadConsidered = smallestQuadConsidered.seChild;
        }
      }
      if(newCabSubSquad == SubQuad.NORTH_WEST) {
        smallestQuadConsidered = smallestQuadConsidered.nwChild;
      } else if(newCabSubSquad == SubQuad.NORTH_EAST) {
        smallestQuadConsidered = smallestQuadConsidered.neChild;
      } else if(newCabSubSquad == SubQuad.SOUTH_WEST) {
        smallestQuadConsidered = smallestQuadConsidered.swChild;
      } else {
        smallestQuadConsidered = smallestQuadConsidered.seChild;
      }
      smallestQuadConsidered.insert(cab, location);

      if(cabSubQuad == SubQuad.NORTH_WEST) {
        parentQuad = parentQuad.nwChild;
      } if(cabSubQuad == SubQuad.NORTH_EAST) {
        parentQuad = parentQuad.neChild;
      } if(cabSubQuad == SubQuad.SOUTH_WEST) {
        parentQuad = parentQuad.swChild;
      } if(cabSubQuad == SubQuad.SOUTH_EAST) {
        parentQuad = parentQuad.seChild;
      }
      parentQuad.insert(this.cab, this.cabLocation);

    }
    else if(quadStatus == QuadStatus.DIVIDED_NODE) {
      if(location.getX() < center.getX() && location.getY() > center.getY()) {
        System.out.println("Recursively inserting cab in northwest of quad with centre {" + center.getX() +","+center.getY()+"}");
        nwChild.insert(cab, location);
      } else if(location.getX() > center.getX() && location.getY() > center.getY()) {
        System.out.println("Recursively inserting cab in northeast of quad with centre {" + center.getX() +","+center.getY()+"}");
        neChild.insert(cab, location);
      } else if(location.getX() < center.getX() && location.getY() < center.getY()) {
        System.out.println("Recursively inserting cab in southwest of quad with centre {" + center.getX() +","+center.getY()+"}");
        swChild.insert(cab, location);
      } else {
        System.out.println("Recursively inserting cab in southeast of quad with centre {" + center.getX() +","+center.getY()+"}");
        seChild.insert(cab, location);
      }

    }
  }

  public Set<Cab> getNearbyCabs(Location userLocation) {
      Set<Cab> cabs = new HashSet<>();
      Quad lowestQuad = this;
      SubQuad subQuad = SubQuad.NOT_ASSIGNED;
      Set<Integer> visited = new HashSet<>();

      while(lowestQuad.quadStatus != QuadStatus.EMPTY_LEAF && lowestQuad.quadStatus != QuadStatus.FILLED_LEAF) {
        subQuad = lowestQuad.locateSubQuad(userLocation);
        if(subQuad == SubQuad.NORTH_WEST) {
          lowestQuad = lowestQuad.nwChild;
        } else if(subQuad == SubQuad.NORTH_EAST) {
          lowestQuad = lowestQuad.neChild;
        } else if(subQuad == SubQuad.SOUTH_WEST) {
          lowestQuad = lowestQuad.swChild;
        } else {
          lowestQuad = lowestQuad.seChild;
        }
      }
      getCabsForParent(lowestQuad, cabs, visited);
      return cabs;
  }

  private void getCabsForParent(Quad lowestQuad, Set<Cab> cabs, Set<Integer> visited) {
    if(cabs.size() >= AppConstants.NO_OF_CABS)
      return;
    if(lowestQuad == null || lowestQuad.getParent() == null)
      return;
    Quad parentQuad = lowestQuad.getParent();
    if(visited.contains(parentQuad.getQuadId()))
      return;
    visited.add(parentQuad.getQuadId());

    if(parentQuad.getNwChild().getQuadStatus() == QuadStatus.DIVIDED_NODE) {
      getCabsForParent(parentQuad.getNwChild(), cabs, visited);
    } else {
      cabs.add(parentQuad.getNwChild().getCab());
    }

    if(parentQuad.getNeChild().getQuadStatus() == QuadStatus.DIVIDED_NODE) {
      getCabsForParent(parentQuad.getNeChild(), cabs, visited);
    } else {
      cabs.add(parentQuad.getNeChild().getCab());
    }

    if(parentQuad.getSwChild().getQuadStatus() == QuadStatus.DIVIDED_NODE) {
      getCabsForParent(parentQuad.getSwChild(), cabs, visited);
    } else {
      cabs.add(parentQuad.getSwChild().getCab());
    }

    if(parentQuad.getSeChild().getQuadStatus() == QuadStatus.DIVIDED_NODE) {
      getCabsForParent(parentQuad.getSeChild(), cabs, visited);
    } else {
      cabs.add(parentQuad.getSeChild().getCab());
    }

  }

  private void createChildren() {
    System.out.println("Dividing the quad with centre {" + center.getX()+"," + center.getY()+"} and halfWidth, halfHeight with " + halfWidth +"," + halfHeight);
    nwChild = new Quad(new Location(center.getX() - halfWidth / 2, center.getY()  + halfHeight /2), halfWidth / 2, halfHeight /2, this);
    neChild = new Quad(new Location(center.getX() + halfWidth /2, center.getY() + halfHeight/2), halfWidth/2, halfHeight/2, this);
    swChild = new Quad(new Location(center.getX() - halfWidth / 2, center.getY() - halfHeight/2), halfWidth / 2, halfHeight/2, this);
    seChild = new Quad(new Location(center.getX() - halfWidth/2, center.getY() - halfHeight/2), halfWidth/2, halfHeight/2, this);
  }

  private boolean containsLocation(Location location) {
    return (location.getX() >= center.getX() - halfWidth && location.getX() < center.getX() + halfWidth
    && location.getY() > center.getY() - halfHeight && location.getY() <= center.getY() + halfHeight);
  }

  private SubQuad locateSubQuad(Location location) {
    if(location.getX() < center.getX() && location.getY() > center.getY())
      return SubQuad.NORTH_WEST;
    else if(location.getX() > center.getX() && location.getY() > center.getY())
      return SubQuad.NORTH_EAST;
    else if(location.getX() < center.getX() && location.getY() < center.getY())
      return SubQuad.SOUTH_WEST;
    return SubQuad.SOUTH_EAST;
  }

  public Location getCenter() {
    return center;
  }

  public double getHalfWidth() {
    return halfWidth;
  }

  public double getHalfHeight() {
    return halfHeight;
  }

  public QuadStatus getQuadStatus() {
    return quadStatus;
  }

  public Cab getCab() {
    return cab;
  }

  public Location getCabLocation() {
    return cabLocation;
  }

  public Quad getNwChild() {
    return nwChild;
  }

  public Quad getNeChild() {
    return neChild;
  }

  public Quad getSwChild() {
    return swChild;
  }

  public Quad getSeChild() {
    return seChild;
  }

  public int getQuadId() {
    return quadId;
  }

  public Quad getParent() {
    return parent;
  }
}
