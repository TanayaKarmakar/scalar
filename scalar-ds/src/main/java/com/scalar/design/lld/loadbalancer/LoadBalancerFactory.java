package com.scalar.design.lld.loadbalancer;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class LoadBalancerFactory {
  public LoadBalancer createLoadBalancer(String lbType) {
    switch (lbType) {
      case "round-robin":
        return new RoundRobinLoadBalancer();
      case "least-connection":
        return new LeastConnectionLoadBalancer();
      default:
        throw new RuntimeException("Invalid type");
    }
  }
}
