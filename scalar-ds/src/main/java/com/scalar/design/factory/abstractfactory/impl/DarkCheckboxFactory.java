package com.scalar.design.factory.abstractfactory.impl;

import com.scalar.design.factory.abstractfactory.interfaces.UICheckboxFactory;
import com.scalar.design.factory.abstractfactory.models.DarkCheckbox;
import com.scalar.design.factory.abstractfactory.models.UICheckbox;

/**
 * @author t0k02w6 on 19/12/22
 * @project scalar-ds
 */
public class DarkCheckboxFactory implements UICheckboxFactory {
  @Override
  public UICheckbox createCheckbox() {
    return new DarkCheckbox();
  }
}
