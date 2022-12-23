package com.scalar.design.decorator.interfaces;

/**
 * @author t0k02w6 on 23/12/22
 * @project scalar-ds
 */
public interface Database {
  String read();

  void write(String value);
}
