package com.scalar.design.factory.abstractfactory.impl;

import com.scalar.design.factory.abstractfactory.interfaces.UIButtonFactory;
import com.scalar.design.factory.abstractfactory.models.LightButton;
import com.scalar.design.factory.abstractfactory.models.UIButton;

/**
 * @author t0k02w6 on 19/12/22
 * @project scalar-ds
 */
public class LightButtonFactory implements UIButtonFactory {
  @Override
  public UIButton createButton() {
    return new LightButton();
  }
}
