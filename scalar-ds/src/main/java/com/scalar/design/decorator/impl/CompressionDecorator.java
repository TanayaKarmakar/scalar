package com.scalar.design.decorator.impl;

import com.scalar.design.decorator.interfaces.Database;

/**
 * @author t0k02w6 on 23/12/22
 * @project scalar-ds
 */
public class CompressionDecorator implements Database {
  private Database database;

  public CompressionDecorator(Database database) {
    this.database = database;
  }

  @Override
  public String read() {
    String value = database.read();
    return deCompress(value);
  }

  private String deCompress(String value) {
    return value + " - Decompress";
  }

  @Override
  public void write(String value) {
    String compressedValue = compress(value);
    database.write(compressedValue);
  }

  private String compress(String value) {
    return value + " - Compressed";
  }
}
