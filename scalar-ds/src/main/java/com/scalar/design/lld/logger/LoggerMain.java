package com.scalar.design.lld.logger;

import com.scalar.design.lld.logger.impl.LogImpl;

/**
 * @author t0k02w6 on 01/03/23
 * @project scalar
 */
public class LoggerMain {
  public static void main(String[] args) {
    LogClient logger = new LogImpl();
    logger.start("1");
    logger.poll();
    logger.start("3");
    logger.poll();
    logger.end("1");
    logger.poll();
    logger.start("2");
    logger.poll();
    logger.end("2");
    logger.poll();
    logger.end("3");
    logger.poll();
    logger.poll();
    logger.poll();
  }
}
