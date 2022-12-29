package com.scalar.design.lld.loadbalancer;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class Destination {
  private String ipAddress;
  private int requestBeingServed;
  private final int threshold;

  public Destination(int threshold) {
    this.threshold = threshold;
  }

  public boolean acceptRequest(Request request) {
    if(threshold <= requestBeingServed) {
      requestBeingServed++;
      return true;
    } else {
      return false;
    }
  }

  private void completeRequest() {
    requestBeingServed--;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public int getRequestBeingServed() {
    return requestBeingServed;
  }

  public int getThreshold() {
    return threshold;
  }
}
