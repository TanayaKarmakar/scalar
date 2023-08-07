package com.scalar.design.lld.loggingframework.logger;

import com.scalar.design.lld.loggingframework.AbstractLogger;
import com.scalar.design.lld.loggingframework.sink.LogSubject;
import java.io.Serializable;

import static com.scalar.design.lld.loggingframework.LogManager.buildChainOfLogger;
import static com.scalar.design.lld.loggingframework.LogManager.buildSubject;

/**
 * @author t0k02w6 on 06/08/23
 * @project scalar-ds
 */
public class Logger implements Cloneable, Serializable {
  private static volatile Logger logger;
  private static volatile AbstractLogger chainOfLogger;
  private static volatile LogSubject logSubject;

  private Logger() {
    if(logger !=null)
      throw new IllegalStateException("Object already created");
  }

  public static Logger getInstance() {
    if(logger == null) {
      synchronized (Logger.class) {
        if(logger == null) {
          logger = new Logger();
          chainOfLogger = buildChainOfLogger();
          logSubject = buildSubject();
        }
      }
    }
    return logger;
  }

  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  protected Object readResolve() {
    return logger;
  }

  private void createLog(int level, String message) {
    chainOfLogger.logMessage(level, message, logSubject);
  }

  public void info(String message) {
    createLog(1, message);
  }

  public void error(String message) {
    createLog(2, message);
  }

  public void debug(String message) {
    createLog(3, message);
  }
}
