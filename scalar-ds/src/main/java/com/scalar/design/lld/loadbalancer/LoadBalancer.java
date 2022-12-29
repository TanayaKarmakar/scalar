package com.scalar.design.lld.loadbalancer;


import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public abstract class LoadBalancer {
  Map<RequestType, Service> serviceMap;

  public void addService(RequestType requestType, Service service) {
    serviceMap.put(requestType, service);
  }

  public Set<Destination> getDestinations(Request request) {
    Service service = serviceMap.get(request.getType());
    return service.getDestinations();
  }

  abstract Destination balanceLoad(Request request);
}
