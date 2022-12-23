package com.scalar.design.decorator.impl;

import com.scalar.design.decorator.interfaces.Database;

/**
 * @author t0k02w6 on 23/12/22
 * @project scalar-ds
 */
public class BaseDecorator implements Database {
  private Database database;

  public BaseDecorator(Database database) {
    this.database = database;
  }

  @Override
  public String read() {
    return database.read();
  }

  @Override
  public void write(String value) {
    database.write(value);
  }
}
