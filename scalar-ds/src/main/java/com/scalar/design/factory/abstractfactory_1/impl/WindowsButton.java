package com.scalar.design.factory.abstractfactory_1.impl;

import com.scalar.design.factory.abstractfactory_1.interfaces.IButton;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class WindowsButton implements IButton {
  @Override
  public void press() {
    System.out.println("Windows Button Pressed");
  }
}
