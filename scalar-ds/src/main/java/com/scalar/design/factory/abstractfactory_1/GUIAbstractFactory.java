package com.scalar.design.factory.abstractfactory_1;

import com.scalar.design.factory.abstractfactory_1.impl.MacFactory;
import com.scalar.design.factory.abstractfactory_1.impl.WindowsFactory;
import com.scalar.design.factory.abstractfactory_1.interfaces.IFactory;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class GUIAbstractFactory {
  public static IFactory createFactory(String osType) {
    if(osType.equals("windows"))
      return new WindowsFactory();
    else if(osType.equals("mac"))
      return new MacFactory();
    return new MacFactory();
  }
}
