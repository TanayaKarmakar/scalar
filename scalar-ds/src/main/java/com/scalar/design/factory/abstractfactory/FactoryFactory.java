package com.scalar.design.factory.abstractfactory;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class FactoryFactory {
  public static GenericButtonFactory createFactory(String type) {
    switch (type) {
      case "round":
        return new RoundButtonFactory();
      case "primary":
        return new PrimaryButtonFactory();
    }
    throw new RuntimeException("Invalid type");
  }
}
