package com.scalar.design.lld.loggingframework;

import com.scalar.design.lld.loggingframework.sink.LogSubject;

/**
 * @author t0k02w6 on 06/08/23
 * @project scalar-ds
 */
public abstract class AbstractLogger {
  public int level;
  AbstractLogger nextLoggingLevel;

  public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
    this.nextLoggingLevel = nextLoggingLevel;
  }

  protected abstract void display(String message, LogSubject logSubject);

  public void logMessage(int level, String message, LogSubject logSubject) {
    if(this.level == level) {
      display(message, logSubject);
    }

    if(nextLoggingLevel != null)
      nextLoggingLevel.logMessage(level, message, logSubject);
  }
}
