package com.scalar.design.revision.observer.impl;

import com.scalar.design.revision.observer.interfaces.ISubscriber;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class User implements ISubscriber {
  private int userId;

  public User(int userId) {
    this.userId = userId;
  }

  @Override
  public void notify(String message) {
    System.out.println("User" + userId + " subscribed to the message " + message);
  }
}
