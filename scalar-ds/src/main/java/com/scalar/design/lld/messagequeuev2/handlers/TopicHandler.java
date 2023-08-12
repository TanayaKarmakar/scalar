package com.scalar.design.lld.messagequeuev2.handlers;

import com.scalar.design.lld.messagequeuev2.models.Topic;
import com.scalar.design.lld.messagequeuev2.models.TopicSubscriber;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class TopicHandler {
  private final Topic topic;
  private final Map<String, SubscriberWorker> subscriberWorkers;

  public TopicHandler(Topic topic) {
    this.topic = topic;
    this.subscriberWorkers = new HashMap<>();
  }

  public void publish() {
    for(TopicSubscriber subscriber: topic.getSubscribers()) {
      startSubscriberWorker(subscriber);
    }
  }

  public void startSubscriberWorker(TopicSubscriber subscriber) {
    final String subscriberId = subscriber.getSubscriber().getId();
    if(!subscriberWorkers.containsKey(subscriberId)) {
      SubscriberWorker subscriberWorker = new SubscriberWorker(topic, subscriber);
      subscriberWorkers.put(subscriberId, subscriberWorker);
      new Thread(subscriberWorker).start();
    }
    final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
    subscriberWorker.wakeUpIfNeeded();
  }
}
