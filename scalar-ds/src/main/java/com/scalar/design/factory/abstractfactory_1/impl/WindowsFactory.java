package com.scalar.design.factory.abstractfactory_1.impl;

import com.scalar.design.factory.abstractfactory_1.interfaces.IButton;
import com.scalar.design.factory.abstractfactory_1.interfaces.IFactory;
import com.scalar.design.factory.abstractfactory_1.interfaces.ITextBox;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class WindowsFactory implements IFactory {
  @Override
  public IButton createButton() {
    return new WindowsButton();
  }

  @Override
  public ITextBox createTextBox() {
    return new WindowsTextBox();
  }
}
