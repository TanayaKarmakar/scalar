package com.scalar.design.lld.loggingframework.sink;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class FileLogger implements LogObserver{
  @Override
  public void log(String message) {
    System.out.println("Write to File : " + message);
  }
}
