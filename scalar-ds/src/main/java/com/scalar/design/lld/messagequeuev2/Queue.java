package com.scalar.design.lld.messagequeuev2;

import com.scalar.design.lld.messagequeuev2.handlers.TopicHandler;
import com.scalar.design.lld.messagequeuev2.interfaces.ISubscriber;
import com.scalar.design.lld.messagequeuev2.models.Message;
import com.scalar.design.lld.messagequeuev2.models.Topic;
import com.scalar.design.lld.messagequeuev2.models.TopicSubscriber;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Queue {
  private final Map<String, TopicHandler> topicProcessors;

  public Queue() {
    this.topicProcessors = new HashMap<>();
  }

  public Topic createTopic(String topicName) {
    final Topic topic = new Topic(UUID.randomUUID().toString(), topicName);
    TopicHandler topicHandler = new TopicHandler(topic);
    topicProcessors.put(topic.getTopicId(), topicHandler);
    System.out.println("Created topic : " + topicName + " with ID: " + topic.getTopicId());
    return topic;
  }

  public void addSubscriber(final ISubscriber subscriber, final Topic topic) {
    TopicSubscriber topicSubscriber = new TopicSubscriber(subscriber);
    topic.addSubscriber(topicSubscriber);
    System.out.println("Added subscriber: " + subscriber.getId());
  }

  public void publish(final Topic topic, final Message message) {
    topic.addMessage(message);
    System.out.println(message.getMessage() + " published to topic: " + topic.getName());
    new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
  }

  public void resetOffset(final Topic topic, final ISubscriber subscriber, final Integer newOffset) {
    for(TopicSubscriber topicSubscriber: topic.getSubscribers()) {
      if(topicSubscriber.getSubscriber().equals(subscriber)) {
        topicSubscriber.getOffset().set(newOffset);
        System.out.println("New Offset " + newOffset + " for subscriber: " + subscriber.getId());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
        break;
      }
    }
  }
}
