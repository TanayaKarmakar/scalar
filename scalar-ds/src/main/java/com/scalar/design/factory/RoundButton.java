package com.scalar.design.factory;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class RoundButton implements Button {
  @Override
  public void onClick() {
    System.out.println("Round Button Clicked");
  }

  @Override
  public void render() {
    System.out.println("Round Button Rendered");
  }
}
