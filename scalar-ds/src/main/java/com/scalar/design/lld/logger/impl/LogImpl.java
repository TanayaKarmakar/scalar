package com.scalar.design.lld.logger.impl;

import com.scalar.design.lld.logger.LogClient;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.scalar.design.lld.logger.entities.Process;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 01/03/23
 * @project scalar
 */
public class LogImpl implements LogClient {
  private final ConcurrentSkipListMap<Long, Process> queue;
  private final Map<String, Process> processMap;
  private final List<CompletableFuture<String>> futures;
  private final Lock lock = new ReentrantLock();
  private final ExecutorService[] taskScheduler;


  public LogImpl() {
    queue = new ConcurrentSkipListMap<>(new Comparator<Long>() {
      @Override
      public int compare(Long startTime1, Long startTime2) {
        return (int)(startTime1 - startTime2);
      }
    });
    this.processMap = new HashMap<>();
    this.futures = new CopyOnWriteArrayList<>();
    this.taskScheduler = new ExecutorService[10];
    for(int i = 0; i < taskScheduler.length; i++) {
      taskScheduler[i] = Executors.newSingleThreadExecutor();
    }
  }

  @Override
  public void start(String processId) {
    int hash = processId.hashCode() % taskScheduler.length;
    taskScheduler[hash].execute(() -> {
      final long now = System.currentTimeMillis();
      final Process process = new Process(processId, now);
      processMap.put(processId, process);
      queue.put(now, process);
    });
  }

  @Override
  public void end(String processId) {
    int hash = processId.hashCode() % taskScheduler.length;
    taskScheduler[hash].execute(() -> {
      lock.lock();
      try {
        final long now = System.currentTimeMillis();
        processMap.get(processId).setEndTime(now);
        if(!futures.isEmpty() &&
            queue.firstEntry().getValue().getId().equals(processId)) {
          final var result = futures.remove(0);
          pollNow();
          result.complete(null);
        }
      } finally {
        lock.unlock();
      }
    });
  }

  @Override
  public String poll() {
      lock.lock();
      try {
        final var result = new CompletableFuture<String>();

        if(!queue.isEmpty()) {
          pollNow();
        } else {
          futures.add(result);
        }

        try {
          result.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
          throw new RuntimeException(e);
        }
        return null;
      } finally {
        lock.unlock();
      }
  }

  private String pollNow() {
    if(!queue.isEmpty() && queue.firstEntry().getValue().getEndTime() != -1) {
      final Process process = queue.firstEntry().getValue();
      final var logStatement = process.getId() + " Started at " + process.getStartTime()
          + " and ended at " + process.getEndTime();
      System.out.println(logStatement);
      processMap.remove(process.getId());
      queue.pollFirstEntry();
      return logStatement;
    }
    return null;
  }
}
