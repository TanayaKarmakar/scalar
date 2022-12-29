package com.scalar.design.lld.loadbalancer;

import java.util.Map;

/**
 * @author t0k02w6 on 29/12/22
 * @project scalar-ds
 */
public class Request {
  private final String id;
  private final RequestType type;
  private final Map<String, String> parameters;

  public Request(String id, RequestType type, Map<String, String> parameters) {
    this.id = id;
    this.type = type;
    this.parameters = parameters;
  }

  public String getId() {
    return id;
  }

  public RequestType getType() {
    return type;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }
}
