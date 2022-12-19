package com.scalar.design.factory.abstractfactory;

import com.scalar.design.factory.models.Button;
import com.scalar.design.factory.models.RoundButton;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class RoundButtonFactory implements GenericButtonFactory{

  @Override
  public Button createButton() {
    return new RoundButton(null, 0);
  }
}
