package com.scalar.design.lld.logger;

/**
 * @author t0k02w6 on 01/03/23
 * @project scalar
 */
public interface LogClient {
  void start(String processId);

  void end(String processId);

  void poll();
}
