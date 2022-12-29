package com.scalar.design.lld.loadbalancer;

import java.util.Set;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class Service {
  private Set<Destination> destinations;

  public void addDestination(Destination destination) {
    destinations.add(destination);
  }

  public void removeDestination(Destination destination) {
    destinations.remove(destination);
  }

  public Set<Destination> getDestinations() {
    return destinations;
  }
}
