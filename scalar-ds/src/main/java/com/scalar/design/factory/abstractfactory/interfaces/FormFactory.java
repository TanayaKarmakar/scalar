package com.scalar.design.factory.abstractfactory.interfaces;

import com.scalar.design.factory.abstractfactory.models.UIButton;
import com.scalar.design.factory.abstractfactory.models.UICheckbox;

/**
 * @author t0k02w6 on 19/12/22
 * @project scalar-ds
 */
public interface FormFactory {
  UIButton createButton();

  UICheckbox createCheckbox();
}
