package com.scalar.design.factory;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class PrimaryButton implements Button{
  @Override
  public void onClick() {
    System.out.println("Primary Button Clicked");
  }

  @Override
  public void render() {
    System.out.println("Primary Button Rendered");
  }
}
