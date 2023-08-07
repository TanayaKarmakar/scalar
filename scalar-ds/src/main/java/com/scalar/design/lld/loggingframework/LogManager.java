package com.scalar.design.lld.loggingframework;

import com.scalar.design.lld.loggingframework.loggertype.DebugLogger;
import com.scalar.design.lld.loggingframework.loggertype.ErrorLogger;
import com.scalar.design.lld.loggingframework.loggertype.InfoLogger;
import com.scalar.design.lld.loggingframework.sink.ConsoleLogger;
import com.scalar.design.lld.loggingframework.sink.FileLogger;
import com.scalar.design.lld.loggingframework.sink.LogSubject;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class LogManager {
  public static AbstractLogger buildChainOfLogger() {
    AbstractLogger infoLogger = new InfoLogger(1);
    AbstractLogger errorLogger = new ErrorLogger(2);
    AbstractLogger debugLogger = new DebugLogger(3);

    infoLogger.setNextLoggingLevel(errorLogger);
    errorLogger.setNextLoggingLevel(debugLogger);

    return infoLogger;
  }

  public static LogSubject buildSubject() {
    LogSubject logSubject = new LogSubject();
    ConsoleLogger consoleLogger = new ConsoleLogger();
    FileLogger fileLogger = new FileLogger();
    logSubject.addObserver(1, consoleLogger);
    logSubject.addObserver(2, consoleLogger);

    logSubject.addObserver(1, fileLogger);
    return logSubject;
  }
}
