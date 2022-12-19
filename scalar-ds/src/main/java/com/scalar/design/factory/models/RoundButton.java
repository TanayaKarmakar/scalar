package com.scalar.design.factory.models;



/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class RoundButton extends Button {
  double radius;

  public RoundButton(String id, double radius) {
    super(id);
    this.radius = radius;
  }

  @Override
  public void onClick() {
    System.out.println("Round Button Clicked");
  }

  @Override
  public void render() {
    System.out.println("Round Button Rendered");
  }
}
