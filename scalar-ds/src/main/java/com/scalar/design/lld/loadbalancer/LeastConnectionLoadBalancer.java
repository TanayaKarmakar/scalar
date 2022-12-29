package com.scalar.design.lld.loadbalancer;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class LeastConnectionLoadBalancer extends LoadBalancer{
  @Override
  Destination balanceLoad(Request request) {
    Set<Destination> destinations = getDestinations(request);

    Destination destination = destinations.stream()
        .min(Comparator.comparingInt(Destination::getRequestBeingServed))
        .orElseThrow();
    destination.acceptRequest(request);
    return destination;
  }
}
