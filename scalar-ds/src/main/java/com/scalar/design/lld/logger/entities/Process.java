package com.scalar.design.lld.logger.entities;

/**
 * @author t0k02w6 on 01/03/23
 * @project scalar
 */
public class Process {
  private final String id;
  private final long startTime;
  private long endTime = -1;

  public Process(final String id, final long startTime) {
    this.id = id;
    this.startTime = startTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public String getId() {
    return id;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return endTime;
  }
}
