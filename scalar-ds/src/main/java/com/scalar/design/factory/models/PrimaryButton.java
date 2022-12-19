package com.scalar.design.factory.models;


/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class PrimaryButton extends Button {
  double height;
  double width;

  public PrimaryButton(String id, double height, double width) {
    super(id);
    this.height = height;
    this.width = width;
  }

  @Override
  public void onClick() {
    System.out.println("Primary Button Clicked");
  }

  @Override
  public void render() {
    System.out.println("Primary Button Rendered");
  }
}
