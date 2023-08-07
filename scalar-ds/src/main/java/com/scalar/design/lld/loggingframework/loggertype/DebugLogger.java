package com.scalar.design.lld.loggingframework.loggertype;

import com.scalar.design.lld.loggingframework.AbstractLogger;
import com.scalar.design.lld.loggingframework.sink.LogSubject;

/**
 * @author t0k02w6 on 06/08/23
 * @project scalar-ds
 */
public class DebugLogger extends AbstractLogger {

  public DebugLogger(int level) {
    this.level = level;
  }

  @Override
  protected void display(String message, LogSubject logSubject) {
    String logMessage = "DEBUG : " + message;
    logSubject.notifyAllObservers(this.level, logMessage);
  }
}
