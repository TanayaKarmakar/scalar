package com.scalar.design.decorator.impl;

import com.scalar.design.decorator.interfaces.Database;

/**
 * @author t0k02w6 on 23/12/22
 * @project scalar-ds
 */
public class SimpleDatabase implements Database {
  @Override
  public String read() {
    return "Base";
  }

  @Override
  public void write(String value) {
    System.out.println(value);
  }
}
