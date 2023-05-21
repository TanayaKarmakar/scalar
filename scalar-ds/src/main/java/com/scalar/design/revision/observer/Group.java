package com.scalar.design.revision.observer;

import com.scalar.design.revision.observer.interfaces.ISubscriber;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class Group {
  private List<ISubscriber> subscribers;

  public Group() {
    this.subscribers = new ArrayList<>();
  }

  public void subscribe(ISubscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void remove(ISubscriber subscriber) {
    subscribers.remove(subscriber);
  }

  public void notify(String message) {
    for(ISubscriber subscriber: subscribers) {
      subscriber.notify(message);
    }
  }
}
