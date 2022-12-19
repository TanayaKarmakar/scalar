package com.scalar.design.factory.abstractfactory.impl;

import com.scalar.design.factory.abstractfactory.interfaces.UICheckboxFactory;
import com.scalar.design.factory.abstractfactory.models.LightCheckbox;
import com.scalar.design.factory.abstractfactory.models.UICheckbox;

/**
 * @author t0k02w6 on 19/12/22
 * @project scalar-ds
 */
public class LightCheckboxFactory implements UICheckboxFactory {
  @Override
  public UICheckbox createCheckbox() {
    return new LightCheckbox();
  }
}
