package com.scalar.design.lld.logger.impl;

import com.scalar.design.lld.logger.LogClient;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import com.scalar.design.lld.logger.entities.Process;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 01/03/23
 * @project scalar
 */
public class LogImpl implements LogClient {
  private final TreeMap<Long, Process> queue;
  private final Map<String, Process> processMap;


  public LogImpl() {
    queue = new TreeMap<>(new Comparator<Long>() {
      @Override
      public int compare(Long startTime1, Long startTime2) {
        return (int)(startTime1 - startTime2);
      }
    });
    this.processMap = new HashMap<>();
  }

  @Override
  public void start(String processId) {
    final long now = System.currentTimeMillis();
    final Process process = new Process(processId, now);
    processMap.put(processId, process);
    queue.put(now, process);
  }

  @Override
  public void end(String processId) {
    final long now = System.currentTimeMillis();
    processMap.get(processId).setEndTime(now);

  }

  @Override
  public void poll() {
    if(!queue.isEmpty()) {
      final Process process = queue.firstEntry().getValue();
      if(process.getEndTime() != -1) {
        System.out.println(process.getId() + " Started at " + process.getStartTime() + " and ended at " + process.getEndTime());
        processMap.remove(process.getId());
        queue.pollFirstEntry();
      } else {
        System.out.println("No completed tasks in queue " + queue.size());
      }
    }

  }
}
