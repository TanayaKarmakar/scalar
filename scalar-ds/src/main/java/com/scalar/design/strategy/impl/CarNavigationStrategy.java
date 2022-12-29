package com.scalar.design.strategy.impl;

import com.scalar.design.strategy.interfaces.NavigationStrategy;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class CarNavigationStrategy implements NavigationStrategy {
  @Override
  public void navigate(String from, String to) {
    System.out.println("Driving by Car");
  }
}
