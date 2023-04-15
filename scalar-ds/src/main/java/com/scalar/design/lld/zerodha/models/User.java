package com.scalar.design.lld.zerodha.models;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class User {
  private String userId;

  public User(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }
}
