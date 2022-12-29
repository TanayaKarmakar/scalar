package com.scalar.design.lld.loadbalancer;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class RoundRobinLoadBalancer extends  LoadBalancer {
  Map<RequestType, Queue<Destination>> destinationForRequest;

  @Override
  Destination balanceLoad(Request request) {
    if(!destinationForRequest.containsKey(request.getType())) {
      Set<Destination> destinations = getDestinations(request);
      destinationForRequest.put(request.getType(), new LinkedList<>(destinations));
    }
    Destination destination = destinationForRequest.get(request.getType()).poll();
    destinationForRequest.get(request.getType()).add(destination);
    destination.acceptRequest(request);
    return destination;
  }
}
