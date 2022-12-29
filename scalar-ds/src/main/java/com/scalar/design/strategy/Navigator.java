package com.scalar.design.strategy;

import com.scalar.design.strategy.interfaces.NavigationStrategy;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class Navigator {
  private NavigationStrategy strategy;

  public Navigator(NavigationStrategy strategy) {
    this.strategy = strategy;
  }

  public void navigate(String from, String to) {
    strategy.navigate(from, to);
  }
}
