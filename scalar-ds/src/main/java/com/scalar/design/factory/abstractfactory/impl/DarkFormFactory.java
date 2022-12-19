package com.scalar.design.factory.abstractfactory.impl;

import com.scalar.design.factory.abstractfactory.interfaces.FormFactory;
import com.scalar.design.factory.abstractfactory.interfaces.UIButtonFactory;
import com.scalar.design.factory.abstractfactory.interfaces.UICheckboxFactory;
import com.scalar.design.factory.abstractfactory.models.UIButton;
import com.scalar.design.factory.abstractfactory.models.UICheckbox;

/**
 * @author t0k02w6 on 19/12/22
 * @project scalar-ds
 */
public class DarkFormFactory implements FormFactory {
  private UIButtonFactory buttonFactory;
  private UICheckboxFactory checkboxFactory;

  public DarkFormFactory(UIButtonFactory buttonFactory, UICheckboxFactory checkboxFactory) {
    this.buttonFactory = buttonFactory;
    this.checkboxFactory = checkboxFactory;
  }

  @Override
  public UIButton createButton() {
    return buttonFactory.createButton();
  }

  @Override
  public UICheckbox createCheckbox() {
    return checkboxFactory.createCheckbox();
  }
}
