package com.scalar.design.lld.loggingframework.loggertype;

import com.scalar.design.lld.loggingframework.AbstractLogger;
import com.scalar.design.lld.loggingframework.sink.LogSubject;

/**
 * @author t0k02w6 on 06/08/23
 * @project scalar-ds
 */
public class ErrorLogger extends AbstractLogger {

  public ErrorLogger(int level) {
    this.level = level;
  }

  @Override
  protected void display(String message, LogSubject logSubject) {
    String logMessage = "ERROR : " + message;
    logSubject.notifyAllObservers(this.level, logMessage);
  }
}
