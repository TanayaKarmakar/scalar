package com.scalar.design.lld.messagequeuev2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Topic {
  private final String topicId;
  private final String name;
  private final List<Message> messages;
  private final List<TopicSubscriber> subscribers;

  public Topic(String topicId, String name) {
    this.topicId = topicId;
    this.name = name;
    this.messages = new ArrayList<>();
    this.subscribers = new ArrayList<>();
  }

  public synchronized void addMessage(Message message) {
    this.messages.add(message);
  }

  public void addSubscriber(TopicSubscriber subscriber) {
    subscribers.add(subscriber);
  }

  public String getTopicId() {
    return topicId;
  }

  public String getName() {
    return name;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public List<TopicSubscriber> getSubscribers() {
    return subscribers;
  }
}
