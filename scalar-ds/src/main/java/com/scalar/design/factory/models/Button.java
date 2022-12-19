package com.scalar.design.factory.models;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public abstract class Button {
  protected String id;

  public Button(String id) {
  }

  abstract void onClick();

  abstract void render();
}
