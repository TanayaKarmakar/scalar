package com.scalar.design.observer.impl;

import com.scalar.design.observer.interfaces.Observer;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class EmailService implements Observer {
  @Override
  public void consume() {
    System.out.println("Sending Email.");
  }
}
