package com.scalar.design.lld.messagequeue.helper;

import com.scalar.design.lld.messagequeue.entities.Message;
import com.scalar.design.lld.messagequeue.helper.mediator.IQueueMediator;
import com.scalar.design.lld.messagequeue.helper.mediator.QueueMediatorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class ConsumerImpl implements IConsumer{
  private final String name;
  private final IQueueMediator queueMediator;
  private final List<String> subscribedTopics;
  private final Map<String, Integer> topicToOffsetMap;

  public ConsumerImpl(String name) {
    this.name = name;
    this.queueMediator = QueueMediatorImpl.getInstance();
    subscribedTopics = new ArrayList<>();
    topicToOffsetMap = new HashMap<>();
    init();
  }

  @Override
  public void subscribeToTopic(String topicName) {
    subscribedTopics.add(topicName);
    topicToOffsetMap.put(topicName, 0);
  }

  private void init() {
    Thread messageConsumerThread = new Thread(this::consumerRunner);
    messageConsumerThread.start();
  }

  private void consumerRunner() {
    while(true) {
      for(String topicName: subscribedTopics) {
        int currentOffset = topicToOffsetMap.get(topicName);
        Optional<Message> message = queueMediator.readMessageIfPresent(topicName, currentOffset);
        if(message.isPresent()) {
          consume(message.get(), topicName, currentOffset);
          currentOffset++;
        }
        topicToOffsetMap.put(topicName, currentOffset);
      }
      try {
        Thread.sleep(100);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }
  }

  private void consume(Message message, String topicName, int currentOffset) {
    System.out.printf("[%s] %s is received message: %s from topic, offset: %d%n", Thread.currentThread().getName(),
        name, message.getMessage(), topicName, currentOffset);
  }
}
