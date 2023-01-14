package com.scalar.design.lld.tinder;

/**
 * @author t0k02w6 on 04/01/23
 * @project scalar-ds
 */
public class Chat {
  private User sender;
  private String description;

  public User getSender() {
    return sender;
  }

  public void setSender(User sender) {
    this.sender = sender;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
