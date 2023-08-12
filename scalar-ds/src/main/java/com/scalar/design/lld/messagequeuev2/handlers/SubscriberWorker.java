package com.scalar.design.lld.messagequeuev2.handlers;

import com.scalar.design.lld.messagequeuev2.models.Message;
import com.scalar.design.lld.messagequeuev2.models.Topic;
import com.scalar.design.lld.messagequeuev2.models.TopicSubscriber;
import lombok.SneakyThrows;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class SubscriberWorker implements Runnable {
  private final Topic topic;
  private final TopicSubscriber subscriber;

  public SubscriberWorker(Topic topic, TopicSubscriber subscriber) {
    this.topic = topic;
    this.subscriber = subscriber;
  }


  @SneakyThrows
  @Override
  public void run() {

    synchronized (subscriber) {
      do {
        int currentOffset = subscriber.getOffset().get();
        while(currentOffset >= topic.getMessages().size()) {
          subscriber.wait();
        }
        Message message = topic.getMessages().get(currentOffset);
        subscriber.getSubscriber().consume(message);
        subscriber.getOffset().compareAndSet(currentOffset,   currentOffset + 1);
      } while(true);
    }
  }

  public synchronized void wakeUpIfNeeded() {
    synchronized (subscriber) {
      subscriber.notifyAll();
    }
  }
}
