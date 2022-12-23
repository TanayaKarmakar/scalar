package com.scalar.design.decorator.impl;

import com.scalar.design.decorator.interfaces.Database;

/**
 * @author t0k02w6 on 23/12/22
 * @project scalar-ds
 */
public class EncryptionDecorator implements Database {
  private Database database;

  public EncryptionDecorator(Database database) {
    this.database = database;
  }
  
  @Override
  public String read() {
    String value = database.read();
    return decrypt(value);
  }

  @Override
  public void write(String value) {
    String encrypted = encrypt(value);
    database.write(encrypted);
  }

  private String encrypt(String value) {
    return value + " - Encrypted";
  }

  private String decrypt(String value) {
    return value + " - Decrypted";
  }
}
