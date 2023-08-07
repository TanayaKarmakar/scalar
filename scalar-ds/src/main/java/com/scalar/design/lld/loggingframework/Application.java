package com.scalar.design.lld.loggingframework;

import com.scalar.design.lld.loggingframework.logger.Logger;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Application {
  public static void main(String[] args) {
    Logger logger = Logger.getInstance();
    logger.info("This is info");
    logger.error("This is error");
    logger.debug("This is debug");
  }
}
