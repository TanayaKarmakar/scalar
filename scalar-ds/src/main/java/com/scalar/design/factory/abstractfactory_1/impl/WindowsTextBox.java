package com.scalar.design.factory.abstractfactory_1.impl;

import com.scalar.design.factory.abstractfactory_1.interfaces.ITextBox;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class WindowsTextBox implements ITextBox {
  @Override
  public void showText() {
    System.out.println("Showing Windows TextBox");
  }
}
