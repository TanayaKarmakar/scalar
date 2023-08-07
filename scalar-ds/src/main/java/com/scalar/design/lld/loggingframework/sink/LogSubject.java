package com.scalar.design.lld.loggingframework.sink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class LogSubject {
  public Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

  public void addObserver(int level, LogObserver logObserver) {
    if(!logObservers.containsKey(level))
      logObservers.put(level, new ArrayList<>());
    logObservers.get(level).add(logObserver);
  }

  public void notifyAllObservers(int level, String message) {
    for(Map.Entry<Integer, List<LogObserver>> entry: logObservers.entrySet()) {
      if(entry.getKey() == level) {
        entry.getValue().forEach(logObserver -> logObserver.log(message));
      }
    }
  }
}
